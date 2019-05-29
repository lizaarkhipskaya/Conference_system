package controller.command;

import model.dto.ConferenceDto;
import model.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetConferenceList implements Command {
    public static  final  int CONF_NUMBER_IN_ONE_PAGE = 6;
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("start get conference list");
        ConferenceService conferenceService = new ConferenceService();
        int counter = request.getParameter("counter")==null ? 0 : Integer.valueOf(request.getParameter("counter"));//change
        List<ConferenceDto> conferenceDtoList = conferenceService.
                getConferenceComingUp(counter,CONF_NUMBER_IN_ONE_PAGE);
        request.setAttribute("conferenceDtoList",conferenceDtoList);
        System.out.println(conferenceDtoList.toString());
        return "/WEB-INF/conference_list.jsp";
    }
}
