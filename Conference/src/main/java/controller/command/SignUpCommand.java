package controller.command;

import controller.manager.ContentManager;
import controller.manager.PathManager;
import model.entity.User;
import model.exeption.ReRegisterExeption;
import model.exeption.ReRegisterUserExeption;
import model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class SignUpCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SignUpCommand.class);
    @Override
    public String execute(HttpServletRequest request) {

        Map<String, String[]> parametersFromRequest = request.getParameterMap();
        Map<String,String> parameters = getAllParameters(parametersFromRequest);

        if(allParamCorrect(parameters)){
            if(checkConfirmPassword(parameters)) {
                UserService userService = new UserService();
                User user = null;
                try {
                    user = userService.addUser(parameters);
                } catch (ReRegisterUserExeption reRegisterUserExeption) {
                    LOGGER.warn("user "+parameters.get("email")+"tried to re-register");
                    ContentManager.setLocalizedMessage(request,"reregistrationUser","reregistrationUser");
                    //request.setAttribute("reregistrationUser",ContentManager.getLocalizedContent("reregistrationUser",Locale.getDefault()));//REFACTOR LOCALE
                    return PathManager.getProperty("sign_up");
                } catch (ReRegisterExeption reRegisterExeption) {
                    LOGGER.warn(reRegisterExeption);
                }
                request.getSession().setAttribute("user", user);
                return "redirect:" + PathManager.getProperty("map_sign_in");
            }
        }

        request.setAttribute("correctParameters",getCorrectParameters(parameters,request));
        return PathManager.getProperty("sign_up");
    }

    public  Map<String,String> getAllParameters(Map<String, String[]> parametersFromRequest){
        Map<String,String> parameters = new HashMap<>();
        for(ValidationEnum v:ValidationEnum.values()){
            if(parametersFromRequest.containsKey(v.toString().toLowerCase())){
                parameters.put(v.toString().toLowerCase(),parametersFromRequest.get(v.toString().toLowerCase())[0]);
            }
            else
                parameters.put(v.toString().toLowerCase(),null);

        }
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
                    ContentManager.setLocalizedMessage(request,"incorrect_"+key,"incorrect."+key);
                    //request.setAttribute("incorrect_"+key, ContentManager.getLocalizedContent("incorrect."+key,Locale.getDefault()));//change locale !!!!!
                }
            }
        return  corectParameters;
    }
    public boolean allParamCorrect(Map<String, String> parameters){
        for (Map.Entry<String,String> e: parameters.entrySet()){
            if(!ValidationEnum.valueOf(e.getKey().toUpperCase()).getValidator().validate(e.getValue()))
                return false;
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
        FIRST_NAME{
            {
                this.validator = (e) -> e!=null && e!="" && e.matches("[а-яА-Я- ]+");
            }
        },
        LAST_NAME{
            {
                this.validator = (e) -> e!=null && e!=""&& e.matches("[а-яА-Я- ]+");
            }
        },
        CONFIRM_PASSWORD{
            {
                this.validator = (e) -> e!=null && e!="" && e.length()>6;
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
