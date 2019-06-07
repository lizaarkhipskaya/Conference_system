package controller.command;

import model.entity.Conference;
import model.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;

public class ConferenceInfoCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long idConference = Long.parseLong(request.getParameter("id"));
        ConferenceService conferenceService = new ConferenceService();
        Conference conference = conferenceService.getById(idConference);
        System.out.println(conference.toString());
        request.setAttribute("conference",conference);
        return "/WEB-INF/conference_info.jsp";
    }
}
