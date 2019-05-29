package model.dao;

import model.entity.Speaker;

import java.util.List;

public interface SpeakerDao extends EntityDao<Speaker,Long>{
    public List<Speaker> getSpeakers(int limit);
}
