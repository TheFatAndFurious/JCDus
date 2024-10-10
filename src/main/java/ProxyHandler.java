import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProxyHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String backendUrl = "http://localhost:8080/";
        URL url = new URL(backendUrl + httpExchange.getRequestURI());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(httpExchange.getRequestMethod());

    }
}
