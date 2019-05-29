package model.dao.mysql;

import model.dao.ConnectionPool;
import model.dao.SpeakerDao;
import model.entity.Speaker;
import model.mapper.SpeakerMapper;
import model.service.SourceEnum;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MySqlSpeakerDao implements SpeakerDao {
    private DataSource source = ConnectionPool.getDatasource();
    private ResourceBundle resourceBundle = ResourceBundle.getBundle(SourceEnum.SQL_STATEMENT.getName());
    private SpeakerMapper speakerMapper = new SpeakerMapper();
    @Override
    public List<Speaker> getSpeakers(int limit) {
        List<Speaker> speakerList = new ArrayList<>();
        Speaker speaker = null;
        try(Connection connection = source.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(resourceBundle.getString("speaker.getSpeakers"));
            preparedStatement.setInt(1,limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                speaker = speakerMapper.mapToObject(resultSet);
                speakerList.add(speaker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return speakerList;
    }

    @Override
    public Speaker getById(Long id) {
        return null;
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
