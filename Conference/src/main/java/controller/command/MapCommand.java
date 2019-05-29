package controller.command;

import controller.manager.PathManager;

import javax.servlet.http.HttpServletRequest;

public class MapCommand implements Command {//check how to change!!!!!!!!!!
    @Override
    public String execute(HttpServletRequest request) {
        String page = request.getParameter("source");
        return MapEnum.valueOf(page.toUpperCase()).getPageName();
    }
    private enum MapEnum{
        SIGNUP(PathManager.getProperty("sign_up")),
        SIGNIN(PathManager.getProperty("sign_in"));
        String pageName;


        MapEnum(String pageName) {
            this.pageName = pageName;
        }

        public String getPageName(){
            return pageName;
        }
    }

}
