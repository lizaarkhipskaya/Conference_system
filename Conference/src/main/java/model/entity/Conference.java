package model.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class Conference {
    private long id;
    private Timestamp date;
    private String theme;
    private List<Speech> speeches;
    private int numberOfAttendees;

    @Override
    public int hashCode(){
        return 0;
    }
}
