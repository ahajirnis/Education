import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;

public class SimpleREST
{
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler
    {
        @Override
        public void handle(HttpExchange he) throws IOException
        {
//            String response = "This is the response";
//            t.sendResponseHeaders(200, response.length());
            String filePath = "D:\\Projects\\TEST\\RESTTEST\\5secrule.pdf";
            File canonicalFile = new File(filePath);
            FileInputStream fis = new FileInputStream(canonicalFile);
            he.sendResponseHeaders(200, canonicalFile.length());
            OutputStream os = he.getResponseBody();
            copyStream(fis, os);
            os.close();
            fis.close();
        }

        private void copyStream(InputStream is, OutputStream os) throws IOException {
            byte[] buf = new byte[4096];
            int n;
            while ((n = is.read(buf)) >= 0) {
                os.write
                        (buf, 0, n);
            }
        }

        private void zipfile ()
        {

        }


    }
}
