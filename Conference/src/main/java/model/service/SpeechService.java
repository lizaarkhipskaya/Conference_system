package model.service;

import model.dao.SpeechDao;
import model.dao.mysql.MySqlDaoFactory;
import model.entity.Speech;
import model.entity.User;
import model.exeption.ReRegisterExeption;
import model.exeption.ReRegisterSpeech;

public class SpeechService {
    private SpeechDao speechDao = MySqlDaoFactory.getInstance().createSpeechDao();

    public long addSpeech(Speech speech) throws ReRegisterExeption {
        return  speechDao.insert(speech);
    }

    public boolean changeTheme(Speech speech) {
        return speechDao.update(speech);
    }
}
