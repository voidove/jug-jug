package com.mybatis.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mybatis.dao.UserDAO;
import com.mybatis.dto.UserInfoDTO;
import com.mybatis.model.User;
import com.mybatis.util.MybatisUtil;

public class UserDAO {
    private static final String SQL_ID_FIND_USERS = ".findUsers";
    private static final String SQL_ID_FIND_USER_BY_NAME_AND_PASSWORD = ".findUserByNameAndPassword";
    private static final String SQL_ID_ADD_USER = ".addUser";
    private static final String SQL_ID_GET_USER_COUNT = ".getUserCount";
    private static final String SQL_ID_FIND_USERS_ORDER_WITH_OPTION = ".findUsersOrderWithOption";
    private static final String SQL_ID_FIND_USER_BY_ID_WITH_MAP = ".findUserByIdWithMap";
    private static final String SQL_ID_FIND_USER_BY_ID = ".findUserById";
    private static final String SQL_ID_DELETE_USER_BY_ID = ".deleteUserById";
    private static final String SQL_ID_UPDATE_USER_BY_ID = ".updateUserById";

    public List<User> findUsers() {
        List<User> result = Collections.emptyList();
        try {
            result = MybatisUtil.getSession().selectList(User.class.getName() + SQL_ID_FIND_USERS);
        } finally {
            MybatisUtil.closeSession();
        }
        return result;
    }

    public Boolean addUser(User user) {
        try {
            MybatisUtil.getSession().insert(User.class.getName() + SQL_ID_ADD_USER, user);
            MybatisUtil.getSession().commit();
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtil.getSession().rollback();
        } finally {
            MybatisUtil.closeSession();
        }
        return Boolean.TRUE;
    }

    public List<UserInfoDTO> findUserByNameAndPassoword(String userName, String password) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("userName", userName);
        params.put("password", password);
        List<UserInfoDTO> result = Collections.emptyList();
        try {
            result = MybatisUtil.getSession().selectList(
                    User.class.getName() + SQL_ID_FIND_USER_BY_NAME_AND_PASSWORD, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession();
        }
        return result;
    }

    public int findUserCount() {
        int result = 0;
        try {
            result = MybatisUtil.getSession().selectOne(
                    User.class.getName() + SQL_ID_GET_USER_COUNT);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession();
        }
        return result;
    }

    public List<User> findUsersOrderWithOption(String value) {
        List<User> result = Collections.emptyList();

        try {
            result = MybatisUtil.getSession().selectList(
                    User.class.getName() + SQL_ID_FIND_USERS_ORDER_WITH_OPTION, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession();
        }
        return result;
    }

    public Map findUsersByIdWithMap(int id) {
        Map result = null;
        try {
            result = MybatisUtil.getSession().selectOne(
                    User.class.getName() + SQL_ID_FIND_USER_BY_ID_WITH_MAP, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession();
        }
        return result;
    }

    public User findUserById(int id) {
        User result = null;
        try {
            result = MybatisUtil.getSession().selectOne(
                    User.class.getName() + SQL_ID_FIND_USER_BY_ID, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession();
        }
        return result;
    }

    public void deleteUserById(int id) {
        try {
            MybatisUtil.getSession().delete(User.class.getName() + SQL_ID_DELETE_USER_BY_ID, id);
            MybatisUtil.getSession().commit();
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtil.getSession().rollback();
        } finally {
            MybatisUtil.closeSession();
        }
    }

    public void updateUserById(int id, String name) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(id));
        params.put("newName", name);
        try {
            MybatisUtil.getSession().update(User.class.getName() + SQL_ID_UPDATE_USER_BY_ID, params);
            MybatisUtil.getSession().commit();
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtil.getSession().rollback();
        } finally {
            MybatisUtil.closeSession();
        }
    }
}
