package service;

import org.hibernate.HibernateException;

import pojo.User;

/** 
 * 余额管理模块
 * @author Lucifer 
 * @date 2017年3月20日 下午9:17:17 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public interface BalanceManager {
	//充值
	public boolean recharge(User user,Double amount) throws HibernateException;
	//提现
	public boolean reflect(User user,Double amount) throws HibernateException;
}
