package controller.command;

import controller.manager.PathManager;

import javax.servlet.http.HttpServletRequest;

public class AddConferenceCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        if(request.getParameter("theme")==null)
            return PathManager.getProperty("add_conference");

        return PathManager.getProperty("add_conference");
    }
}
