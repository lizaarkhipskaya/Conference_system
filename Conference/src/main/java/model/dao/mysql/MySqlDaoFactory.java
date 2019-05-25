package model.dao.mysql;

import model.dao.DaoFactory;
import model.dao.DaoSpeech;
import model.dao.DaoUser;

public class MySqlDaoFactory implements DaoFactory {
    @Override
    public DaoUser getDaoUser() {
        return new MySqlDaoUser();
    }

    @Override
    public DaoSpeech getDaoSpeaeh() {
        return new MySqlDaoSpeech();
    }
}
