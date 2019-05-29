package model.mapper;

import model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements Mapper<User, ResultSet> {
    @Override
    public User mapToObject(ResultSet rs) throws SQLException {
        return new User.Builder()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setSurname(rs.getString("surname"))
                .setEmail(rs.getString("email"))
                .setPassword(rs.getString("password"))
                .setRole(User.Role.valueOf(rs.getString("role").toUpperCase()))
                .build();
    }
}
