package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.User;

/**
 * UserManager��ҵ��ӿڶ��壬
 *
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��15�� ����9:42:27
 * @parameter
 * @return
 */
public interface UserManager {
    //��½����
    public String login(User user) throws HibernateException;

    //ע�Ṧ��
    public boolean register(User user) throws HibernateException;

    //�鿴ȫ���û�
    public List<User> getUsers() throws HibernateException;

    //�鿴�û�����
    public List<User> findUserInfo(User user) throws HibernateException;

    //�޸ĸ�������
    public boolean updateUserInfo(User user) throws HibernateException;

    //�޸�����
    public boolean updateUserPW(User user) throws HibernateException;

    //根据用户名查找用户类
    public User findUserByName(String userName) throws HibernateException;

    //根据用户名查找用户余额
    public double getUserBalance(String userName) throws HibernateException;

}
