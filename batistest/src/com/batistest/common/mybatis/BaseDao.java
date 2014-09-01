package com.batistest.common.mybatis;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public abstract class BaseDao<T, K> extends SqlSessionDaoSupport {

    protected static String SQL_ID_ADD = ".add";
    protected static String SQL_ID_UPDATE = ".update";
    protected static String SQL_ID_DELETE = ".delete";
    protected static String SQL_ID_BY_ID = ".getById";

    private Class<T> clz;

    @SuppressWarnings("unchecked")
    protected Class<T> getClz() {
        if (clz == null) {
            clz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return clz;
    }

    public Boolean add(T obj) {
        getSqlSession().insert(this.getClz().getName() + SQL_ID_ADD, obj);
        return Boolean.TRUE;
    }

    public Boolean delete(K id) {
        getSqlSession().delete(this.getClz().getName() + SQL_ID_DELETE, id);
        return Boolean.TRUE;
    }

    public Boolean update(T obj) {
        getSqlSession().update(this.getClz().getName() + SQL_ID_UPDATE, obj);
        return Boolean.TRUE;
    }

    @SuppressWarnings("unchecked")
    public T getById(K id) {
        return (T) getSqlSession().selectOne(this.getClz().getName() + SQL_ID_BY_ID, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findByQueryId(String sqlId, Object parameters) {
        return (List<T>) getSqlSession().selectList(this.getClz().getName() + sqlId, parameters);
    }

}
