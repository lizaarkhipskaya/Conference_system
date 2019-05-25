package model.dao;

public interface DaoEntity<E,K> {
    E getById(K id);
    K insert(E e);
    boolean update(E e);
    boolean remove(E e);
}
