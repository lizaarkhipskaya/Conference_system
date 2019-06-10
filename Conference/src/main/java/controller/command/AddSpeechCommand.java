package controller.command;

import controller.manager.ContentManager;
import controller.manager.PathManager;
import model.entity.Speaker;
import model.entity.Speech;
import model.entity.User;
import model.exeption.ReRegisterExeption;
import model.exeption.ReRegisterSpeech;
import model.service.SpeechService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class AddSpeechCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(AddSpeechCommand.class);
    @Override
    public String execute(HttpServletRequest request) {

        SpeechService speechService = new SpeechService();

        String theme = request.getParameter("theme");
        String idConference = request.getParameter("id");

        if(!validateTheme(theme)){
            ContentManager.setLocalizedMessage(request,"incorrectTheme","incorrectTheme");
            //request.setAttribute("incorrectTheme",ContentManager.getLocalizedContent("incorrectTheme", Locale.getDefault()));//LOCALEEEELLLELELLEL
            return PathManager.getProperty("main_page");
        }

        Speaker speaker = (Speaker) request.getSession().getAttribute("user");

        Speech speech = Speech.builder()
                .theme(theme)
                .idConference(Long.valueOf(idConference))
                .speaker(speaker)
                .build();

        try {
            speechService.addSpeech(speech);
        } catch (ReRegisterSpeech reRegisterSpeech) {
            LOGGER.warn("Speaker"+speaker.toString()+" re-register speech",reRegisterSpeech);
            ContentManager.setLocalizedMessage(request,"incorrectSpeechRegister","incorrectSpeechRegister");
            //request.setAttribute("incorrectSpeechRegister",ContentManager.getLocalizedContent("incorrectSpeechRegister",Locale.getDefault()));
            return PathManager.getProperty("main_page");
        } catch (ReRegisterExeption reRegisterExeption) {
            LOGGER.warn(reRegisterExeption);
        }
        ContentManager.setLocalizedMessage(request,"successfullyCompletedAdd","successfullyCompletedAdd");
        return PathManager.getProperty("main_page");
    }

    private boolean validateTheme(String theme) {
        return  theme!=null&&theme.length()>1&&theme.matches("[а-яА-Я-.;: ]+");
    }
}
