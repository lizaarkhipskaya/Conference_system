package controller.util;

import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class SecurityUtil {
    public static final Map<User.Role, String[]> securityMap = new HashMap<User.Role, String[]>() {{
        put(User.Role.SPEAKER, new String[]{"today_conferences","main_page", "add_speech", "conference_info", "up_coming_conferences", "speaker_list", "registration_on_conference","past_conferences"});
        put(User.Role.ADMIN, new String[]{"today_conferences","main_page", "conference_info", "up_coming_conferences", "speaker_list", "registration_on_conference","past_conferences"});
        put(User.Role.MODERATOR, new String[]{"add_conference","today_conferences","main_page", "conference_info", "up_coming_conferences", "speaker_list", "registration_on_conference","past_conferences"});
        put(User.Role.LISTENER, new String[]{"today_conferences","main_page", "conference_info", "up_coming_conferences", "speaker_list", "registration_on_conference","past_conferences"});
    }};

    public static final String[] securitySet = {"sign_up","sign_in","change_language","about","map"};

    public boolean isSecureRequest(HttpServletRequest request) {
        String command = request.getRequestURI().replaceAll(".*/app*.", "");
        String roleString = (String) request.getSession().getAttribute("role");
        System.out.println("command in filter"+command);
        System.out.println("role in filter "+roleString);
        if (roleString == null) {
            System.out.println("role = null");
            if (Arrays.asList(securitySet).contains(command)){
                System.out.println("contains "+command);
                return true;
            }
            return false;
        }
        User.Role role = User.Role.valueOf(roleString.toUpperCase());
        Arrays.stream(securityMap.get(role)).forEach(s -> System.out.print(s+" "));
        return Arrays.asList(securityMap.get(role)).contains(command) || Arrays.asList(securitySet).contains(command);
    }
}
