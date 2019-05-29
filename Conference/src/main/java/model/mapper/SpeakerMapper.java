package model.mapper;

import model.entity.Speaker;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpeakerMapper implements Mapper<Speaker, ResultSet> {
    @Override
    public Speaker mapToObject(ResultSet resultSet) throws SQLException {
        return  Speaker.builder()
                .name(resultSet.getString("name"))
                .surname(resultSet.getString("surname"))
                .reating(Integer.valueOf(resultSet.getString("reating")))
                .build();
    }
}
