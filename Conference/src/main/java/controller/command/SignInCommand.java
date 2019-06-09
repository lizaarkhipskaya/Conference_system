package controller.command;

import controller.manager.PathManager;
import model.entity.Speaker;
import model.entity.User;
import model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class SignInCommand implements Command {
    public static  final Logger LOGGER = LogManager.getLogger(SignInCommand.class);
    @Override
    public String execute(HttpServletRequest request) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        User user = userService.checkEmailPassword(email,password);
        System.out.println(user.toString());
        if(user == null){
            return PathManager.getProperty("sign_in");//change
        }

        HttpSession httpSession = request.getSession();

        if(isUserSessionSingle(request)){
            request.getServletContext().setAttribute(email,httpSession);
        }else{
            ((HttpSession)request.getServletContext().getAttribute(email)).invalidate();
            request.getServletContext().removeAttribute(email);
            LOGGER.warn("User "+user.toString()+"tried to sign in from other device or browser");
        }

        httpSession.setAttribute("role",user.getRole().toString().toLowerCase());
        httpSession.setAttribute("user",user);

        return "redirect:"+PathManager.getProperty("main_page");//page_main and main_page !!!
    }


    public boolean isUserSessionSingle(HttpServletRequest request){
        return request.getServletContext().getAttribute("email") == null;
    }

}
