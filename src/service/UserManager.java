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
    public String login(User user) throws HibernateException;

    //注锟结功锟斤拷
    public boolean register(User user) throws HibernateException;

    //锟介看全锟斤拷锟矫伙拷
    public List<User> getUsers() throws HibernateException;

    //锟介看锟矫伙拷锟斤拷锟斤拷
    public User findUserInfo(User user) throws HibernateException;

    //锟睫改革拷锟斤拷锟斤拷锟斤拷
    public boolean updateUserInfo(User user) throws HibernateException;

    //锟睫革拷锟斤拷锟斤拷
    public boolean updateUserPW(User user) throws HibernateException;

    public User findUserByName(String userName) throws HibernateException;

}
