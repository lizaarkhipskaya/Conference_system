package controller.command;

import javax.servlet.http.HttpServletRequest;

public class MapCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = request.getParameter("source");
        System.out.println(MapEnum.valueOf(page.toUpperCase()).getPageName());
        return "/WEB-INF/"+MapEnum.valueOf(page.toUpperCase()).getPageName();
    }
    private enum MapEnum{
        SIGNUP("sign_up.jsp"),
        SIGNIN("sign_in.jsp");

        String pageName;


        MapEnum(String pageName) {
            this.pageName = pageName;
        }

        public String getPageName(){
            return pageName;
        }
    }

}
