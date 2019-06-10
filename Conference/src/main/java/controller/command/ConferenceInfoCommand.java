package controller.command;

import controller.manager.ContentManager;
import model.entity.Conference;
import model.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;

public class ConferenceInfoCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        long idConference = Long.parseLong(request.getParameter("id"));

        ConferenceService conferenceService = new ConferenceService();
        Conference conference = conferenceService.getById(idConference);
        request.setAttribute("conference",conference);

        if(request.getAttribute("sameTheme")!=null){
            System.out.println("sameTheme != null");
            ContentManager.setLocalizedMessage(request,"sameTheme","sameTheme");
        }
        System.out.println(request.getSession().getAttribute("role"));
        System.out.println(conference.toString());
        return "/WEB-INF/conference_info.jsp";
    }
}
