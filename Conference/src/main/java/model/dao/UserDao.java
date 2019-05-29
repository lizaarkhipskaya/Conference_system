package model.dao;

import model.entity.User;

public interface UserDao extends EntityDao<User, Long> {
    /* public static Map<String, User.Role> roleHashMap = new HashMap<>();
         static{
             roleHashMap.put("m", User.Role.MODERATOR);
             roleHashMap.put("a", User.Role.ADMIN);
             roleHashMap.put("s", User.Role.SPEEKER);
             roleHashMap.put("u", User.Role.USER);
         }*/
    User checkEmailPassword(String email, String password);
    //??
}
