package model.dao;

import model.dto.ConferenceDto;
import model.entity.Conference;

import java.util.List;

public interface ConferenceDao extends EntityDao<Conference, Long> {
    List<ConferenceDto> getComingUp(int counter, int confNumberInOnePage);
}
