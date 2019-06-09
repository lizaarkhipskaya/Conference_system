package controller.command;

import controller.manager.ContentManager;
import controller.manager.PathManager;
import model.dto.ConferenceDto;
import model.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class GetMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("role"));
        if(request.getSession().getAttribute("role").equals("speaker")||request.getSession().getAttribute("role")=="speaker"){
            System.out.println("speaker role");
            ConferenceService conferenceService = new ConferenceService();
            List<ConferenceDto> conferenceDtoList = conferenceService.
                    getConferenceForSpeech();
            if (request.getAttribute("incorrectSpeechRegister")!=null)
                request.setAttribute("incorrectSpeechRegister", ContentManager.getLocalizedContent("incorrectSpeechRegister", Locale.getDefault()));
            if(request.getAttribute("successfullyCompletedAdd")!=null)
                request.setAttribute("successfullyCompletedAdd",ContentManager.getLocalizedContent("successfullyCompletedAdd",Locale.getDefault()));
            request.setAttribute("conferenceDtoList",conferenceDtoList);
        }
        return PathManager.getProperty("main_page_jsp");
    }
}
