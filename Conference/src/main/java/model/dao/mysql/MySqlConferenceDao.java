package model.dao.mysql;

import controller.manager.SqlStatementManager;
import model.mapper.ConferenceDtoMapper;
import model.mapper.ConferenceMapper;
import model.mapper.SpeakerMapper;
import model.mapper.SpeechMapper;
import model.dao.ConnectionPool;
import model.dao.ConferenceDao;
import model.dto.ConferenceDto;
import model.entity.Conference;
import model.entity.Speaker;
import model.entity.Speech;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class MySqlConferenceDao implements ConferenceDao {
    private DataSource source = ConnectionPool.getDatasource();
    private ConferenceMapper conferenceMapper = new ConferenceMapper();
    private ConferenceDtoMapper conferenceDtoMapper = new ConferenceDtoMapper();
    private SpeakerMapper speakerMapper = new SpeakerMapper();
    private SpeechMapper speechMapper = new SpeechMapper();
    private static final Logger LOGGER = LogManager.getLogger(MySqlConferenceDao.class);
    @Override
    public Conference getById(Long id) {
        List<Speech> speeches = new ArrayList<>();
        Conference conference = null;
        try(Connection connection = source.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SqlStatementManager.getProperty("conferenceGetById"));
            ps.setInt(1,id.intValue());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
                Speaker speaker = speakerMapper.mapToObject(resultSet);
                Speech speech = speechMapper.mapToObject(resultSet);
                speech.setSpeaker(speaker);
                speeches.add(speech);
            }
            resultSet.previous();
            conference = conferenceMapper.mapToObject(resultSet);
            conference.setSpeeches(speeches);

        } catch (SQLException e) {
            LOGGER.error(e);
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
                ps = connection.prepareStatement(SqlStatementManager.getProperty("conferenceGetUpcoming"));
                ps.setInt(1, counter*confNumberInOnePage);
                ps.setInt(2, confNumberInOnePage);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ConferenceDto conferenceDto = conferenceDtoMapper.mapToObject(rs);
                conferenceDtoList.add(conferenceDto);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return conferenceDtoList;
    }

    @Override
    public List<ConferenceDto> getTodayConferenceList() {
        List<ConferenceDto> conferenceDtoList = new ArrayList<>();
        try(Connection connection = source.getConnection()) {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(SqlStatementManager.getProperty("conferenceGetToday"));
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                ConferenceDto conferenceDto = conferenceDtoMapper.mapToObject(rs);
                conferenceDtoList.add(conferenceDto);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return conferenceDtoList;
    }

    @Override
    public List<ConferenceDto> getPast(int counter, int confNumberInOnePage) {
        List<ConferenceDto> conferenceDtoList = new ArrayList<>();
        try(Connection connection = source.getConnection()) {
            PreparedStatement ps = null;
            ps = connection.prepareStatement(SqlStatementManager.getProperty("conferenceGetPast"));
            ps.setInt(1, counter*confNumberInOnePage);
            ps.setInt(2, confNumberInOnePage);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ConferenceDto conferenceDto = conferenceDtoMapper.mapToObject(rs);
                conferenceDtoList.add(conferenceDto);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return conferenceDtoList;
    }

}
