package model.dao;

import model.entity.User;

public interface UserDao extends EntityDao<User, Long> {
    User checkEmailPassword(String email, String password);
}
