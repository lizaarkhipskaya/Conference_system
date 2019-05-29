package controller;

import controller.command.CommandFactory;
import controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("servler");
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.getCommand(request);
        String page = command.execute(request);
        if (page.contains("redirect:")) {
            //LOG.trace("page with redirect: " + page);
            //LOG.trace("path after filtering: " + request.getContextPath() + page.replace("redirect:", ""));
            response.sendRedirect(request.getContextPath() + page.replace("redirect:", ""));
        } else {
            //LOG.trace( "page" + page);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
// вызов страницы ответа на запрос
            System.out.println("before forward dispatcher");
            dispatcher.forward(request, response);
            //request.getRequestDispatcher(page).forward(request,response);
        }

    }
}
