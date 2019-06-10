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
        if(request.getSession().getAttribute("role").equals("speaker")||request.getSession().getAttribute("role")=="speaker"){
            ConferenceService conferenceService = new ConferenceService();
            List<ConferenceDto> conferenceDtoList = conferenceService.
                    getConferenceForSpeech();
            if (request.getAttribute("incorrectSpeechRegister")!=null)
                ContentManager.setLocalizedMessage(request,"incorrectSpeechRegister","incorrectSpeechRegister");
                //request.setAttribute("incorrectSpeechRegister", ContentManager.getLocalizedContent("incorrectSpeechRegister", Locale.getDefault()));
            if(request.getAttribute("successfullyCompletedAdd")!=null)
                ContentManager.setLocalizedMessage(request,"successfullyCompletedAdd","successfullyCompletedAdd");
                //request.setAttribute("successfullyCompletedAdd",ContentManager.getLocalizedContent("successfullyCompletedAdd",Locale.getDefault()));

            request.setAttribute("conferenceDtoList",conferenceDtoList);
        }
        return PathManager.getProperty("main_page_jsp");
    }
}
