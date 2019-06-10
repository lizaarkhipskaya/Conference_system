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
        SIGN_UP(PathManager.getProperty("sign_up")),
        SIGN_IN(PathManager.getProperty("sign_in")),
        ABOUT(PathManager.getProperty("about"));
        String pageName;


        MapEnum(String pageName) {
            this.pageName = pageName;
        }

        public String getPageName(){
            return pageName;
        }
    }

}
