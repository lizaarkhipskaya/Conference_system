package model.service;

import model.dao.mysql.MySqlDaoFactory;
import model.dao.mysql.MySqlDaoUser;
import model.entity.User;

public class UserService {
    private MySqlDaoFactory mySqlDaoFactory = new MySqlDaoFactory();//можно ли сделать в дао фактори методы статическими
    public User checkEmailPassword(String email, String password){
        MySqlDaoUser mySqlDaoUser = (MySqlDaoUser) mySqlDaoFactory.getDaoUser();
        return mySqlDaoUser.checkEmailPassword(email,password);
    }
}
