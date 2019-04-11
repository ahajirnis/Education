import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
        public void handle(HttpExchange httpExchange) throws IOException
        {
//            String response = "This is the response";
//            t.sendResponseHeaders(200, response.length());
            String filePath = "D:\\Projects\\TEST\\RESTTEST\\5secrule.pdf";
//            File canonicalFile = new File(filePath);
//            FileInputStream fis = new FileInputStream(canonicalFile);
//            he.sendResponseHeaders(200, canonicalFile.length());

//            OutputStream os = he.getResponseBody();
//            copyStream(fis, os);
//            os.close();
//            fis.close();

            InputStream  in = new FileInputStream(filePath);
            byte[] res = readResource(in,true);
            httpExchange.getResponseHeaders().set("Content-Encoding", "gzip");
            httpExchange.sendResponseHeaders(200, res.length);
            httpExchange.getResponseBody().write(res);
            httpExchange.getResponseBody().close();

        }

        private static byte[] readResource(InputStream in, boolean gzip) throws IOException {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            OutputStream gout = gzip ? new GZIPOutputStream(bout) : new DataOutputStream(bout);
            byte[] tmp = new byte[4096];
            int r;
            while ((r=in.read(tmp)) >= 0)
                gout.write(tmp, 0, r);
            gout.flush();
            gout.close();
            in.close();
            return bout.toByteArray();
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
