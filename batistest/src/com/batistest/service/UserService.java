package com.batistest.service;

import java.util.List;

import com.batistest.dto.UserDTO;
import com.batistest.model.User;

public interface UserService {
    Boolean addUser(User user);

    List<UserDTO> findUsers();

    UserDTO findUserById(Integer id);

    Boolean updateUser(UserDTO userDTO);

    Boolean deleteUser(Integer id);
}
