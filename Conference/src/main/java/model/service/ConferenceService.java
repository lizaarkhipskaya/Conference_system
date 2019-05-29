package model.service;

import model.dao.ConferenceDao;
import model.dao.mysql.MySqlConferenceDao;
import model.dao.mysql.MySqlDaoFactory;
import model.dto.ConferenceDto;
import model.entity.Conference;

import java.util.List;

public class ConferenceService {
    private ConferenceDao conferenceDao = MySqlDaoFactory.getInstance().createConferenceDao();
    public List<ConferenceDto> getConferenceComingUp(int counter, int confNumberInOnePage){
        return conferenceDao.getComingUp(counter,confNumberInOnePage);
    }
    public Conference getById(long id){
        return conferenceDao.getById(id);
    }


}
