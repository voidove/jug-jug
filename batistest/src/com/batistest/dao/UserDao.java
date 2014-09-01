package com.batistest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.batistest.common.mybatis.IBaseDao;
import com.batistest.dto.UserDTO;
import com.batistest.model.User;

@Repository
public interface UserDao extends IBaseDao<User, Integer> {
    List<UserDTO> findUsers();
}
