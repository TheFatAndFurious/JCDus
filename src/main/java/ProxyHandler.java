import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProxyHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String backendUrl = "http://localhost:8080/";
        var requestMethod = httpExchange.getRequestMethod();

        URL url = new URL(backendUrl + httpExchange.getRequestURI());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestMethod);


        // getRequestHeaders returns Headers from the request in the form of key-values
        httpExchange.getRequestHeaders().forEach((key, value)-> {
            connection.setRequestProperty(key, String.join(",", value));
        });


        // Forward request body if applicable
        if("POST".equalsIgnoreCase(requestMethod) || "PUT".equalsIgnoreCase(requestMethod)) {
            connection.setDoOutput(true);
            OutputStream requestBody = connection.getOutputStream();
            requestBody.write(httpExchange.getRequestBody().readAllBytes());
            requestBody.close();
        }
    }
}
