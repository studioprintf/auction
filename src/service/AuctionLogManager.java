package service;

import java.util.List;

import org.hibernate.HibernateException;

/** 
 * 拍卖纪录管理
 * @author Lucifer 
 * @date 2017年3月20日 下午9:11:34 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public interface AuctionLogManager {
	//查看出价纪录
	public List<?> getAuctionLog() throws HibernateException;
	//查看用户发布的拍卖
	public List<?> getUserAuciton() throws HibernateException;
	//用户查看得标的拍卖
	public List<?> getUserSuccess() throws HibernateException;
	
}
