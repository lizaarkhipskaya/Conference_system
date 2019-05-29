package controller.command;

import model.entity.User;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class SignUpCommand implements Command {
    public  ResourceBundle rs = ResourceBundle.getBundle("jsp_path");
    @Override
    public String execute(HttpServletRequest request) {

        Map<String, String[]> parametersFromRequest = request.getParameterMap();
        Map<String,String> parameters = getAllParameters(parametersFromRequest);

        if(allParamCorrect(parameters)||checkConfirmPassword(parameters)){
            UserService userService = new UserService();
            User user = userService.addUser(parameters);
            request.getSession().setAttribute("user",user);
            return  "redirect:/"+user.getRole().toString().toLowerCase()+rs.getString("page_main");
        }
        Map<String, String> correctParam = getCorrectParameters(parameters, request);
        request.setAttribute("correctParameters",getCorrectParameters(parameters,request));
        return rs.getString("sign_up");
    }

    public  Map<String,String> getAllParameters(Map<String, String[]> parametersFromRequest){
        Map<String,String> parameters = new HashMap<>();
        parametersFromRequest.entrySet().stream()
                .map(x -> parameters.put(x.getKey(),x.getValue()[0] ));
        return  parameters;
    }

    public boolean checkConfirmPassword(Map<String, String> parameters){//rename
        return parameters.get("password").equals(parameters.get("confirm_password"));
    }

    public Map<String,String> getCorrectParameters(Map<String, String> parameters, HttpServletRequest request){
        Map<String,String> corectParameters = new HashMap<>();
        String key, value;
        for (Map.Entry<String, String> entry:
                parameters.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                if(ValidationEnum.valueOf(key.toUpperCase()).validator.validate(value)) {
                    corectParameters.put(key, value);
                }
                else {
                    System.out.println(value + " incorrect");
                    request.setAttribute("incorrect_"+key, rs.getString("incorrect."+key));
                }
            }
        return  corectParameters;
    }
    public boolean allParamCorrect(Map<String, String> parameters){
        String key, value;
        for (Map.Entry<String, String> entry:
                parameters.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            if(ValidationEnum.valueOf(key.toUpperCase()).validator.validate(value)) {
                return false;
            }
        }
        return true;
    }
    public enum ValidationEnum{
        EMAIL{
            {
                this.validator = (e) -> e!=null && e!="" && e.matches("[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+");
            }
        },
        PASSWORD{
            {
                this.validator = (e) -> e!=null && e!="" && e.length()>6;
            }
        },
        NAME{
            {
                this.validator = (e) -> e!=null && e!="" && e.matches("[а-яА-Я- ]+");
            }
        },
        SURNAME{
            {
                this.validator = (e) -> e!=null && e!=""&& e.matches("[а-яА-Я- ]+");
            }
        },
        CONFIRM_PASSWORD{
            {
                this.validator = (e) -> e!=null && e!="";
            }
        },
        ROLE{
            {
                this.validator = (e) -> e!=null && e!="";
            }
        };
        Validator validator;
        public Validator getValidator(){
            return validator;
        }
    }
    public interface Validator{
        boolean validate(String parametr);
    }
}
