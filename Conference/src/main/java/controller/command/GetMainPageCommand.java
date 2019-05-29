package controller.command;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class GetMainPageCommand implements Command {
    public static final ResourceBundle rs = ResourceBundle.getBundle("jsp_path");
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("main page");
        return rs.getString("main_page");
    }
}
