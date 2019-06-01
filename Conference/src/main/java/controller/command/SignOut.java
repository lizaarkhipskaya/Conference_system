package controller.command;

import controller.manager.PathManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class SignOut implements Command{
    private static final Logger LOGGER = LogManager.getLogger(SignOut.class);
    @Override
    public String execute(HttpServletRequest request) {
        LOGGER.info("User "+request.getSession().getAttribute("user").toString()+" is sign out.");

        request.getServletContext().removeAttribute((String) request.getSession().getAttribute("email"));
        request.getSession().invalidate();

        return PathManager.getProperty("index");
    }
}
