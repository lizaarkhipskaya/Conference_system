package model.dao.mysql;

import model.dao.*;

public class MySqlDaoFactory extends DaoFactory {

    @Override
    public UserDao createUserDao() {
        return new MySqlUserDao();
    }

    @Override
    public SpeechDao createSpeechDao() {
        return new MySqlSpeechDao();
    }

    @Override
    public ConferenceDao createConferenceDao() {
        return new MySqlConferenceDao();
    }

    @Override
    public SpeakerDao createSpeakerDao() {
        return new MySqlSpeakerDao();
    }
}
