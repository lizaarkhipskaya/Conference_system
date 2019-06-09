package controller.command;

import controller.manager.PathManager;
import model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class SignOutCommand implements Command{
    private static final Logger LOGGER = LogManager.getLogger(SignOutCommand.class);
    @Override
    public String execute(HttpServletRequest request) {

        if(request.getSession().getAttribute("user")==null)
            return "redirect:"+PathManager.getProperty("index");

        LOGGER.info("User "+request.getSession().getAttribute("user").toString()+" is sign out.");
        if(request.getSession().getAttribute(((User)request.getSession().getAttribute("user")).getEmail())!=null)
            request.getServletContext().removeAttribute((String) request.getSession().getAttribute(((User)request.getSession().getAttribute("user")).getEmail()));
        request.getSession().invalidate();

        return "redirect:"+PathManager.getProperty("index");
    }
}
