package model.service;

import model.exeption.ReRegisterExeption;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService;
    @Before public void setUp(){
        userService = new UserService();
    }
    @Test(expected = ReRegisterExeption.class)
    public void addUser() throws ReRegisterExeption {
        userService.addUser(new HashMap<String, String>(){
            {
                put("email","bogdan@gmail.com");
                put("password","password");
                put("first_name","name");
                put("last_name","surname");
                put("role","listener");
            }
        });
    }

}