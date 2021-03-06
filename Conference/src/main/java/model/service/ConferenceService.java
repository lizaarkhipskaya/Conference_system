package model.service;

import model.dao.ConferenceDao;
import model.dao.mysql.MySqlDaoFactory;
import model.dto.ConferenceDto;
import model.entity.Conference;
import model.exeption.ReRegisterExeption;

import java.util.List;

public class ConferenceService {
    private ConferenceDao conferenceDao = MySqlDaoFactory.getInstance().createConferenceDao();
    public List<ConferenceDto> getConferenceComingUp(int counter, int confNumberInOnePage){
        return conferenceDao.getComingUp(counter,confNumberInOnePage);
    }
    public List<ConferenceDto> getTodayConferenceList(){
        return conferenceDao.getTodayConferenceList();
    }
    public Conference getById(long id){
        return conferenceDao.getById(id);
    }


    public List<ConferenceDto> getPastConferenceList(int counter, int confNumberInOnePage) {
        return conferenceDao.getPast(counter,confNumberInOnePage);
    }

    public List<ConferenceDto> getConferenceForSpeech() {
        return  conferenceDao.getConferencesForSpeech();
    }

    public long getCountOfRowsInConferenceList(int timeFlag){return conferenceDao.getCountOfRowsInConferenceList(timeFlag);}

    public long insert(Conference conference) throws ReRegisterExeption {
        return conferenceDao.insert(conference);
    }
}
