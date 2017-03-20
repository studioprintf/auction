package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.User;

/** 
 * UserManager的业务接口定义，
 * 
 * 
 * @author Lucifer 
 * @date 2017年3月15日 上午9:42:27 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public interface UserManager {
	//登陆功能
	public String login(User user) throws HibernateException;
	//注册功能
	public boolean register(User user) throws HibernateException;
	//查看全部用户
	public List<User> getUsers() throws HibernateException;
	//查看用户资料
	public List<User> findUserInfo(User user) throws HibernateException;
	//修改个人资料
	public boolean updateUserInfo(User user) throws HibernateException;
	//修改密码
	public boolean updateUserPW(User user) throws HibernateException;
}
