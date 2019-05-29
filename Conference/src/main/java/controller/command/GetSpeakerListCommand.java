package controller.command;

import model.entity.Conference;
import model.entity.Speaker;
import model.service.SourceEnum;
import model.service.SpeakerService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ResourceBundle;

public class GetSpeakerListCommand implements Command {
    public static final int LIMIT = 10;
    private ResourceBundle resourceBundle = ResourceBundle.getBundle(SourceEnum.JSP_PATH.getName());
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("run speaker list");
        SpeakerService speakerService = new SpeakerService();
        List<Speaker> speakerList = speakerService.getSpeakers(LIMIT);
        System.out.println(speakerList.toString());
        request.setAttribute("speakerList",speakerList);
        return resourceBundle.getString("speakerList");
    }
}
