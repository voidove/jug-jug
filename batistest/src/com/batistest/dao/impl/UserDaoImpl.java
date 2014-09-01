package com.batistest.dao.impl;

import java.util.List;

import com.batistest.common.mybatis.BaseDao;
import com.batistest.dao.UserDao;
import com.batistest.dto.UserDTO;
import com.batistest.model.User;

public class UserDaoImpl extends BaseDao<User, Integer> implements UserDao {

    private static final String SQL_ID_FIND_USERS = ".findUsers";

    @Override
    public List<UserDTO> findUsers() {
        return getSqlSession().selectList(User.class.getName() + SQL_ID_FIND_USERS);
    }

}
