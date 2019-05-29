package model.mapper;

import java.sql.SQLException;

public interface Mapper<E,K> {
    E mapToObject(K k) throws SQLException;
}
