package controller.command;

import controller.manager.PathManager;
import model.dto.ConferenceDto;
import model.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetPastConferenceList implements Command {
    public static  final  int CONF_NUMBER_IN_ONE_PAGE = 6;
    @Override
    public String execute(HttpServletRequest request) {
        ConferenceService conferenceService = new ConferenceService();
        int counter = request.getParameter("counter")==null ? 0 : Integer.valueOf(request.getParameter("counter"));//change
        List<ConferenceDto> conferenceDtoList = conferenceService.
                getPastConferenceList(counter,CONF_NUMBER_IN_ONE_PAGE);
        request.setAttribute("conferenceDtoList",conferenceDtoList);
        return PathManager.getProperty("conference_list");
    }
}
