package model.dao.mysql;

import controller.manager.SqlStatementManager;
import model.dao.ConnectionPool;
import model.dao.SpeechDao;
import model.entity.Speech;
import model.exeption.ReRegisterOnConferenceExeption;
import model.exeption.ReRegisterSpeech;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlSpeechDao implements SpeechDao {
    private DataSource source = ConnectionPool.getDatasource();
    private static final Logger LOGGER = LogManager.getLogger(MySqlSpeakerDao.class);
    @Override
    public Speech getById(Long id) {
        return null;
    }

    @Override
    public Long insert(Speech speech) throws ReRegisterSpeech{
        Long id = null;
        try(Connection connection = source.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatementManager.getProperty("speechInsert"),java.sql.Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1,(int)speech.getSpeaker().getId());
            preparedStatement.setInt(2,(int)speech.getIdConference());
            preparedStatement.setString(3,speech.getTheme());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            id = Long.valueOf(rs.getInt(1));
            System.out.println("id"+id);

        } catch (SQLException e) {
            LOGGER.warn(e);
            if(e.getErrorCode() == 1062||e.getMessage().contains("Duplicate entry"))
                throw  new ReRegisterSpeech();
        }
        return id;
    }

    @Override
    public boolean update(Speech speech) {
        try(Connection connection = source.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatementManager.getProperty("speechUpdate"));
            preparedStatement.setString(1, speech.getTheme());
            preparedStatement.setInt(2,(int)speech.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return true;
    }

    @Override
    public boolean remove(Speech speech) {
        return false;
    }
}
