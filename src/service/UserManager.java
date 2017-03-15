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
	public String login(User user) throws HibernateException;
	public boolean register(User user) throws HibernateException;
	public List<User> getUsers() throws HibernateException;
	public boolean recharge(User user,Double amount) throws HibernateException;
	public boolean reflect(User user,Double amount) throws HibernateException;
}
