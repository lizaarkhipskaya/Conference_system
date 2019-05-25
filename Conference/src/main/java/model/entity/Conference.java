package model.entity;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Conference {
    private long id;
    private Date date;
    private String theme;
    private List<Speech> speeches;
    private List<Speaker> speakers;

}
