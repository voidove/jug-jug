package com.batistest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.batistest.model.User;
import com.batistest.service.UserService;

public class MainTest {

    public static void main(String[] args) {
        try {
            User user = new User();
            user.setUserName("eee");
            user.setPassword("123");

            String contextFileName = "applicationContext.xml";
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(contextFileName);
            UserService userService = (UserService) applicationContext.getBean("userService");
            userService.addUser(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
