package controller.command;

import controller.manager.PathManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("Change language command");
        request.getSession().setAttribute("locale", request.getParameter("locale"));
        String requestURI = (String) request.getAttribute("javax.servlet.forward.request_uri");
            return "redirect:" + requestURI==null ? PathManager.getProperty("index") : requestURI;//TEST THIS
    }
}
