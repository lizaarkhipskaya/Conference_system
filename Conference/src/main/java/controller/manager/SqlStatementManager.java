package controller.manager;

import java.util.ResourceBundle;

public class SqlStatementManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sql_statement");
    private SqlStatementManager(){}
    public static String getProperty(String key){
        return resourceBundle.getString(key);
    }
}
