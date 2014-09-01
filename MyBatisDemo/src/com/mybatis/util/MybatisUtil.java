package com.mybatis.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
    private static String CONFIG_FILE = "mybatis-config.xml";

    private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sessionFactory;

    private MybatisUtil() {
    }

    public static SqlSession getSession() {
        SqlSession session = (SqlSession) threadLocal.get();

        if (session == null) {
            if (sessionFactory == null) {
                buildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            threadLocal.set(session);
        }

        return session;
    }

    public static void buildSessionFactory() {
        try {
            Reader reader = Resources.getResourceAsReader(CONFIG_FILE);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeSession() {
        SqlSession session = (SqlSession) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    public static void closeSessionFactory() {
        sessionFactory = null;
    }
}