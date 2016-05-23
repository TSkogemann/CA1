package dk.skogemann.web;

import dk.skogemann.Server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Thomas Skogemann on 23-05-2016.
 */
public class StartServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

        try {
            Server server = new Server();
            System.out.println("Starting server");
            server.start(9000);
            System.out.println("Server running");
        } catch (IOException e) {
            throw new ServletException("unable to start", e);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.print("<html>Har startet server på port 9000</html>");
        writer.flush();
    }
}
