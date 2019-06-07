package controller.command;

import controller.manager.PathManager;
import model.dto.ConferenceDto;
import model.entity.Conference;
import model.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetTodayConferenceList implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        ConferenceService conferenceService = new ConferenceService();
        int counter = request.getParameter("counter")==null ? 0 : Integer.valueOf(request.getParameter("counter"));//change
        List<ConferenceDto> conferenceDtoList = conferenceService.
                getTodayConferenceList();
        request.setAttribute("conferenceDtoList",conferenceDtoList);
        return PathManager.getProperty("conference_today");
    }
}
