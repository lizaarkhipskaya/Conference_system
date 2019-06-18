package model.dao;

import model.exeption.ReRegisterExeption;
import model.exeption.ReRegisterSpeech;

public interface EntityDao<Long,K> {
    Long getById(K id);
    K insert(Long e) throws ReRegisterExeption;
    boolean update(Long e);
    boolean remove(Long e);
}
