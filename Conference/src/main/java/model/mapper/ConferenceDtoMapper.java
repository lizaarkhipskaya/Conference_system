package model.mapper;

import model.dto.ConferenceDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ConferenceDtoMapper implements Mapper<ConferenceDto, ResultSet> {
    @Override
    public ConferenceDto mapToObject(ResultSet rs) throws SQLException {
        return ConferenceDto.builder()
                .id(Long.valueOf(rs.getString("id")))
                .date(Timestamp.valueOf(rs.getString("date")))
                .theme(rs.getString("theme"))
                .numberOfAttendees(rs.getInt("num_of_attendees"))
                .build();
    }
}
