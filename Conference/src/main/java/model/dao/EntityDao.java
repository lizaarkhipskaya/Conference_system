package model.dao;

import model.exeption.ReRegisterExeption;
import model.exeption.ReRegisterSpeech;

public interface EntityDao<E,K> {
    E getById(K id);
    K insert(E e) throws ReRegisterExeption;
    boolean update(E e);
    boolean remove(E e);
}
