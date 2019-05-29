package controller.command;

import model.entity.User;
import model.service.UserService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class SignInCommand implements Command {
    public static final ResourceBundle rs = ResourceBundle.getBundle("jsp_path");
    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        User user = userService.checkEmailPassword(email,password);
        if(user == null){
            return "/WEB-INF/sign_in.jsp";//change
        }
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("role",user.getRole().toString().toLowerCase());
        httpSession.setAttribute("user",user);
        ///System.out.println("redirect:/"+user.getRole().toString().toLowerCase()+rs.getString("page_main")+"?role="+user.getRole().toString().toLowerCase());
        return "redirect:/"+"app/main_page";
    }
}
