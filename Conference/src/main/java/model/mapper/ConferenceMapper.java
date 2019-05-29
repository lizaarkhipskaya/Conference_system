package model.mapper;

import model.dto.ConferenceDto;
import model.entity.Conference;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ConferenceMapper implements Mapper<Conference, ResultSet> {
    @Override
    public Conference mapToObject(ResultSet resultSet) throws SQLException {
        return Conference.builder()
                .id(Long.valueOf(resultSet.getString("conference_id")))
                .date(Timestamp.valueOf(resultSet.getString("date")))
                .theme(resultSet.getString("conference_theme"))
                .build();
    }
}
