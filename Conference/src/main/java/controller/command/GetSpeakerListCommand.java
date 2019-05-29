package controller.command;

import controller.manager.PathManager;
import model.entity.Speaker;
import model.service.SpeakerService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ResourceBundle;

public class GetSpeakerListCommand implements Command {
    public static final int LIMIT = 10;
    @Override
    public String execute(HttpServletRequest request) {
        SpeakerService speakerService = new SpeakerService();
        List<Speaker> speakerList = speakerService.getSpeakers(LIMIT);
        request.setAttribute("speakerList",speakerList);
        return PathManager.getProperty("speakerList");
    }
}
