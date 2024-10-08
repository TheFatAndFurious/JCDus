import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;

public class HttpServerTest {

    @Test
    public void TestServerStartsAndResponds() throws Exception{

        // create server
        HttpServer server = new HttpServer();
        server.start(8080);

        //create request
        URL url = new URL("http://localhost:8079");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        int responseCode = urlConnection.getResponseCode();

        assertEquals(200, responseCode);

        server.stop(0);
    }
}
