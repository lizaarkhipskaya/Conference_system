package controller;

import controller.command.CommandFactory;
import controller.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    private final static Logger LOGGER = LogManager.getLogger(MainServlet.class);
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.getCommand(request);
        String page = command.execute(request);
        if (page.contains("redirect:")) {
            LOGGER.trace("page with redirect: " + page);
            response.sendRedirect(request.getContextPath() + page.replace("redirect:", ""));
        } else {
            LOGGER.trace( "page" + page);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }

    }
}
//add log configuration