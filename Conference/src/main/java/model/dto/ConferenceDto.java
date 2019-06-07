package model.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;


@Data
@Builder
public class ConferenceDto {
    private long id;
    private Timestamp date;
    private String theme;
    private int numberOfAttendees;
}
