package model.dao.mysql;

import model.mapper.ConferenceDtoMapper;
import model.mapper.ConferenceMapper;
import model.mapper.SpeakerMapper;
import model.mapper.SpeechMapper;
import model.service.SourceEnum;
import model.dao.ConnectionPool;
import model.dao.ConferenceDao;
import model.dto.ConferenceDto;
import model.entity.Conference;
import model.entity.Speaker;
import model.entity.Speech;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class MySqlConferenceDao implements ConferenceDao {
    private DataSource source = ConnectionPool.getDatasource();
    private ResourceBundle resourceBundle = ResourceBundle.getBundle(SourceEnum.SQL_STATEMENT.getName());
    private ConferenceMapper conferenceMapper = new ConferenceMapper();
    private ConferenceDtoMapper conferenceDtoMapper = new ConferenceDtoMapper();
    private SpeakerMapper speakerMapper = new SpeakerMapper();
    private SpeechMapper speechMapper = new SpeechMapper();
    @Override
    public Conference getById(Long id) {
        List<Speech> speeches = new ArrayList<>();
        Conference conference = null;
        try(Connection connection = source.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(resourceBundle.getString("conferenceGetById"));
            ps.setInt(1,id.intValue());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Speaker speaker = speakerMapper.mapToObject(resultSet);
                Speech speech = speechMapper.mapToObject(resultSet);
                speech.setSpeaker(speaker);
                speeches.add(speech);
            }
            resultSet.previous();
            conference = conferenceMapper.mapToObject(resultSet);
            conference.setSpeeches(speeches);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conference;
    }

    @Override
    public Long insert(Conference conference) {
        return null;
    }

    @Override
    public boolean update(Conference conference) {
        return false;
    }

    @Override
    public boolean remove(Conference conference) {
        return false;
    }
    @Override
    public List<ConferenceDto> getComingUp(int counter, int confNumberInOnePage){
        List<ConferenceDto> conferenceDtoList = new ArrayList<>();
        try(Connection connection = source.getConnection()) {
            PreparedStatement ps = null;
                ps = connection.prepareStatement(resourceBundle.getString("conferenceGetUpcoming"));
                ps.setInt(1, counter*confNumberInOnePage);
                ps.setInt(2, confNumberInOnePage);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ConferenceDto conferenceDto = conferenceDtoMapper.mapToObject(rs);
                conferenceDtoList.add(conferenceDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conferenceDtoList;
    }

}
