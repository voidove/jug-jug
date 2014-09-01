package com.batistest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.batistest.dto.UserDTO;
import com.batistest.model.User;
import com.batistest.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    protected static String SUCCESS = "success";

    @RequestMapping("/add")
    public String addUser() {
        User user = new User();
        user.setUserName("ada");
        user.setPassword("234");
        userService.addUser(user);
        return SUCCESS;
    }

    @RequestMapping("/list")
    public ModelAndView listUsers() {
        List<UserDTO> userDTOList = userService.findUsers();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user-list");
        mav.addObject(userDTOList);
        return mav;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable("id") int id) {
        UserDTO userDTO = userService.findUserById(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user-info");
        mav.addObject(userDTO);
        return mav;
    }

    @RequestMapping("/update")
    public String updateUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setUserName("olivier");
        userDTO.setPassword("456");
        userService.updateUser(userDTO);
        return SUCCESS;
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return SUCCESS;
    }

}
