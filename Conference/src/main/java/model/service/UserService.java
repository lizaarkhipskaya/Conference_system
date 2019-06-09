package model.service;

import controller.command.RegistrationOnConferenceCommand;
import model.dao.UserDao;
import model.dao.mysql.MySqlDaoFactory;
import model.dao.mysql.MySqlUserDao;
import model.entity.Conference;
import model.entity.User;
import model.exeption.ReRegisterExeption;
import model.exeption.ReRegisterOnConferenceExeption;

import java.util.Map;

public class UserService {
    private UserDao userDao = MySqlDaoFactory.getInstance().createUserDao();
    public User checkEmailPassword(String email, String password){
        return userDao.checkEmailPassword(email,password);
    }
    public User addUser(Map<String,String> parameters) throws ReRegisterExeption {
        User user = new User.Builder()
                .setRole(User.Role.valueOf(parameters.get("role").toUpperCase()))
                .setPassword(parameters.get("password"))
                .setEmail(parameters.get("email"))
                .setName(parameters.get("first_name"))
                .setSurname(parameters.get("last_name"))
                .build();
        long id = userDao.insert(user);
        user.setId(id);
        return user;
    }
    public boolean registerOnConference(User user, long id) throws ReRegisterOnConferenceExeption {
        return userDao.registrateOnConference(user,id);
    }

}
