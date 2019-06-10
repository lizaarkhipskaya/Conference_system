package controller.command;

import controller.manager.ContentManager;
import controller.manager.PathManager;
import model.entity.Speech;
import model.service.SpeechService;

import javax.servlet.http.HttpServletRequest;

public class NewThemeForSpeechCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

       String newTheme = request.getParameter("new_theme");

        Speech speech = Speech.builder()
                            .id(Long.valueOf(request.getParameter("idSpeech")))
                            .theme(request.getParameter("themeSpeech"))
                            .build();
        Integer idConference = null;


        try {
            idConference = Integer.parseInt(request.getParameter("idConference"));
        }catch (NumberFormatException e){
            return "redirect:"+PathManager.getProperty("up_coming_conferences_request");
        }

        System.out.println("thene"+newTheme);
        System.out.println("id"+request.getParameter("idSpeech"));
        System.out.println(speech.toString());

        if(newTheme.equals(speech.getTheme())){
            System.out.println("same themes!!");
            ContentManager.setLocalizedMessage(request,"sameTheme","sameTheme");
            return "redirect:"+PathManager.getProperty("conference_info_with_id")+idConference.toString();
        }

        speech.setTheme(newTheme);

        SpeechService speechService = new SpeechService();
        speechService.changeTheme(speech);

        return "redirect:"+PathManager.getProperty("conference_info_with_id")+idConference.toString();
    }
}
