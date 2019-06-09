package model.service;

import model.dao.SpeakerDao;
import model.dao.UserDao;
import model.dao.mysql.MySqlDaoFactory;
import model.entity.Speaker;

import java.util.List;

public class SpeakerService {
    private SpeakerDao speakerDao = MySqlDaoFactory.getInstance().createSpeakerDao();

    public List<Speaker> getSpeakers(int limit){
        return speakerDao.getSpeakers(limit);
    }

    public Speaker getById(long id){
        return speakerDao.getById(id);
    }
}
