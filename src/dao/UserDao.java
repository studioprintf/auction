package dao;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.User;

public interface UserDao {

    public void saveObject(User user) throws HibernateException;

    public List<User> getUsers() throws HibernateException;

    public void updateObject(User user) throws HibernateException;

    public User findUser(User user) throws HibernateException;

    public User findUserByName(String userName) throws HibernateException;


}
