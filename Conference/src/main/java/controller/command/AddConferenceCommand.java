package controller.command;

import controller.manager.ContentManager;
import controller.manager.PathManager;
import model.entity.Conference;
import model.exeption.ReRegisterExeption;
import model.service.ConferenceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddConferenceCommand implements Command{
    public static final int MIN_THEME_LENGTH = 6;
    private static final Logger LOGGER = LogManager.getLogger(AddConferenceCommand.class);
    public static final Format formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm a");

    @Override
    public String execute(HttpServletRequest request) {
        String theme = request.getParameter("theme");

        if(!isThemeValidate(theme)) {
            ContentManager.setLocalizedMessage(request,"invalidTheme","invalidTheme");
            return PathManager.getProperty("add_conference");
        }

        String date = request.getParameter("date");



        Timestamp dateTime = getDate(date);
        if(!isDateValidate(dateTime)) {
            ContentManager.setLocalizedMessage(request,"invalidDate","invalidDate");
            return PathManager.getProperty("add_conference");
        }
        System.out.println("Date"+dateTime);
        Conference conference = Conference.builder()
                .theme(theme)
                .date(dateTime)
                .build();

        ConferenceService conferenceService = new ConferenceService();

        try {
            conferenceService.insert(conference);
        } catch (ReRegisterExeption reRegisterExeption) {
            LOGGER.warn(reRegisterExeption);
            ContentManager.setLocalizedMessage(request,"reregistrationConference","reregistrationConference");
            return PathManager.getProperty("add_conference");
        }

        ContentManager.setLocalizedMessage(request,"successfullyAddedConference","successfullyAddedConference");
        return PathManager.getProperty("add_conference");
    }

    public boolean isThemeValidate(String theme){
        return theme!=null&&theme.length()>MIN_THEME_LENGTH&&theme.matches("[А-Яа-я.,;-? ]+");
    }

    public boolean isDateValidate(Timestamp dateTime){
        return dateTime.compareTo(new Timestamp(System.currentTimeMillis()))>0;
    }

    public Timestamp getDate(String date){
        java.util.Date date1 = null;
        try {
            date1 = (java.util.Date) formatter.parseObject(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp ts=new Timestamp(date1.getTime());
        return ts;
    }
}
