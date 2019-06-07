package controller.manager;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

public class ContentManager {
    private ContentManager(){}
    public static String getLocalizedContent(String key, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("page_content", locale);
        return bundle.containsKey(key) ? bundle.getString(key) : "";
    }
    public static void setLocalizedMessage(HttpServletRequest request, String attributeKey, String messageKey) {
        request.setAttribute(attributeKey, getLocalizedContent(messageKey,  Locale.forLanguageTag((String) request.getSession().getAttribute("locale"))));
    }
}
