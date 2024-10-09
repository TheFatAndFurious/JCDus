import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
public class Server {

private HttpServer server;

    public void Start(int Port)throws Exception{
        server = HttpServer.create(new InetSocketAddress(Port), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    public void Stop(){
        server.stop(0);
    }

    static class MyHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

        }
    }
}
