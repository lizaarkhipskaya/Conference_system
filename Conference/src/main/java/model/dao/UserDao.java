package model.dao;

import model.entity.Conference;
import model.entity.User;
import model.exeption.ReRegisterOnConferenceExeption;

public interface UserDao extends EntityDao<User, Long> {

    boolean registrateOnConference(User user, long id) throws ReRegisterOnConferenceExeption;

    User checkEmailPassword(String email, String password);
}
