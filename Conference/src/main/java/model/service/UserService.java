package model.service;

import model.dao.UserDao;
import model.dao.mysql.MySqlDaoFactory;
import model.dao.mysql.MySqlUserDao;
import model.entity.User;

import java.util.Map;

public class UserService {
    private UserDao userDao = MySqlDaoFactory.getInstance().createUserDao();
    public User checkEmailPassword(String email, String password){
        return userDao.checkEmailPassword(email,password);
    }
    public User addUser(Map<String,String> parameters){
        User user = new User.Builder()
                .setRole(User.Role.valueOf(parameters.get("role").toUpperCase()))
                .setPassword(parameters.get("password"))
                .setEmail(parameters.get("email"))
                .setName(parameters.get("name"))
                .setSurname(parameters.get("surname"))
                .build();
        long id = userDao.insert(user);
        user.setId(id);
        return user;
    }

}
