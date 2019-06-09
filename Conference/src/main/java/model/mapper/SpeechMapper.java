package model.mapper;

import model.entity.Speech;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class SpeechMapper implements Mapper<Speech, ResultSet> {

    @Override
    public Speech mapToObject(ResultSet resultSet) throws SQLException {
        return  Speech.builder()
                .theme(resultSet.getString("speech_theme"))
                .build();
    }
}
