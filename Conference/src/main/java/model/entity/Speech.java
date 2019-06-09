package model.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
public class Speech {
    private long id;
    private Speaker speaker;
    private long idConference;
    private String theme;
}
