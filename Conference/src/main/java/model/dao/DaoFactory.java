package model.dao;

import model.dao.mysql.MySqlDaoFactory;

public abstract class DaoFactory {

    private static volatile DaoFactory daoFactory;

    public abstract UserDao createUserDao();

    public abstract SpeechDao createSpeechDao();

    public abstract ConferenceDao createConferenceDao();

    public abstract SpeakerDao createSpeakerDao();

    static public DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new MySqlDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
