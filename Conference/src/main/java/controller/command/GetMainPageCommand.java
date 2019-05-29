package controller.command;

import controller.manager.PathManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class GetMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PathManager.getProperty("main_page_jsp");
    }
}
