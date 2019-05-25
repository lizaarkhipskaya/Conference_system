package controller.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    //ResourceBundle PATH_BUNDLE = ResourceBundle.getBundle(ResourceEnum.PATHS_BUNDLE.getBundleName());
    String execute(HttpServletRequest request);
}
