package model.service;

import java.util.ResourceBundle;

public enum SourceEnum {
    SQL_STATEMENT{
        {
            this.name = "sql_statement";
        }
    },
    JSP_PATH{
        {
            this.name = "jsp_path";
        }
    };

    String name;
    public String getName(){
        return name;
    }
}
