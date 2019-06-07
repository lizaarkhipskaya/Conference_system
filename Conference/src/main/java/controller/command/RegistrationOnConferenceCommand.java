package controller.command;

import controller.manager.ContentManager;
import controller.manager.PathManager;
import model.entity.User;
import model.exeption.ReRegisterOnConferenceExeption;
import model.service.UserService;
import org.apache.commons.lang3.LocaleUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class RegistrationOnConferenceCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        UserService userService = new UserService();
        HttpSession httpSession = request.getSession();
        Locale locale = LocaleUtils.toLocale((String) request.getSession().getAttribute("locale"));

        long conferenceId = Long.valueOf(request.getParameter("id"));

        try {
            userService.registerOnConference((User)httpSession.getAttribute("user"),conferenceId);
        } catch (ReRegisterOnConferenceExeption reRegisterOnConferenceExeption) {
            reRegisterOnConferenceExeption.printStackTrace();
            request.setAttribute("reregistration", ContentManager.getLocalizedContent("reregistration", Locale.getDefault()));//REFACTOR LOCALE
            return PathManager.getProperty("conference_info_with_id")+conferenceId;
        }

        return "redirect:"+ PathManager.getProperty("main_page");
    }
}
