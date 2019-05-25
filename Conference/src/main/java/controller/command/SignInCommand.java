package controller.command;

import model.entity.User;
import model.service.UserService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class SignInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        User user = userService.checkEmailPassword(email,password);
        if(user == null){
            return "/WEB-INF/sign_in.jsp";
        }
        System.out.println(user.toString());
        return "redirect:"+"/WEB-INF/"+user.getRole().toString().toLowerCase()+"_main.jsp";
    }
}
