package controller.command;

import controller.manager.PathManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute("locale", request.getParameter("locale"));
        String requestURI =  request.getHeader("referer");
            return "redirect:" + (requestURI==null ? PathManager.getProperty("index") : requestURI);
    }
}
