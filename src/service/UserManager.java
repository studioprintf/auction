package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.User;

/**
 * UserManager锟斤拷业锟斤拷涌诙锟斤拷澹�
 *
 * @author Lucifer
 * @version 1.0
 * @date 2017锟斤拷3锟斤拷15锟斤拷 锟斤拷锟斤拷9:42:27
 * @parameter
 * @return
 */
public interface UserManager {
    //锟斤拷陆锟斤拷锟斤拷
    String login(User user) throws HibernateException;
    
    //管理员登陆
    String adminLogin(User user) throws HibernateException;

    //注锟结功锟斤拷
    boolean register(User user) throws HibernateException;

    //锟介看全锟斤拷锟矫伙拷
    List<User> getUsers() throws HibernateException;

    //锟介看锟矫伙拷锟斤拷锟斤拷
    User findUserInfo(User user) throws HibernateException;

    //锟睫改革拷锟斤拷锟斤拷锟斤拷
    boolean updateUserInfo(User user) throws HibernateException;

    //锟睫革拷锟斤拷锟斤拷
    boolean updateUserPW(User user,String oldPassword) throws HibernateException;

    //根据用户名查找用户类
    User findUserByName(String userName) throws HibernateException;

}
