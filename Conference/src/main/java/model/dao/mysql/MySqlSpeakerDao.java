package model.dao.mysql;

import controller.manager.SqlStatementManager;
import model.dao.ConnectionPool;
import model.dao.SpeakerDao;
import model.entity.Speaker;
import model.mapper.SpeakerMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlSpeakerDao implements SpeakerDao {
    private DataSource source = ConnectionPool.getDatasource();
    private SpeakerMapper speakerMapper = new SpeakerMapper();
    private static final Logger LOGGER = LogManager.getLogger(MySqlSpeakerDao.class);
    @Override
    public List<Speaker> getSpeakers(int limit) {
        List<Speaker> speakerList = new ArrayList<>();
        Speaker speaker = null;
        try(Connection connection = source.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatementManager.getProperty("speakerGetSpeakers"));
            preparedStatement.setInt(1,limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                speaker = speakerMapper.mapToObject(resultSet);
                speakerList.add(speaker);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return speakerList;
    }

    @Override
    public Speaker getById(Long id) {
        Speaker speaker = null;
        try(Connection connection = source.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatementManager.getProperty("speakerGetById"));
            preparedStatement.setInt(1,id.intValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            speaker = speakerMapper.mapToObjectWithAllParams(resultSet);

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return speaker;
    }

    @Override
    public Long insert(Speaker speaker) {
        return null;
    }

    @Override
    public boolean update(Speaker speaker) {
        return false;
    }

    @Override
    public boolean remove(Speaker speaker) {
        return false;
    }
}
