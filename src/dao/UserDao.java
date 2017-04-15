package dao;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.User;

public interface UserDao {

    void saveObject(User user) throws HibernateException;

    List<User> getUsers() throws HibernateException;

    void updateObject(User user) throws HibernateException;

    User findUser(User user) throws HibernateException;

    User findUserByName(String userName) throws HibernateException;

    User findUserById(int user_id) throws HibernateException;
}
