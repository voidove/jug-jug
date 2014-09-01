package com.batistest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.batistest.common.base.BaseService;
import com.batistest.dao.UserDao;
import com.batistest.dto.UserDTO;
import com.batistest.model.User;
import com.batistest.service.UserService;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Boolean addUser(User user) {
        userDao.add(user);
        return Boolean.TRUE;
    }

    @Override
    public UserDTO findUserById(Integer id) {
        User user = userDao.getById(id);
        UserDTO userDTO = (UserDTO) copyObject(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public List<UserDTO> findUsers() {
        return userDao.findUsers();
    }

    @Override
    public Boolean updateUser(UserDTO userDTO) {
        User user = (User) copyObject(userDTO, User.class);
        userDao.update(user);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        UserDTO userDTO = findUserById(id);
        if (userDTO == null) {
            return Boolean.TRUE;
        }

        userDao.delete(id);
        return Boolean.TRUE;
    }

}
