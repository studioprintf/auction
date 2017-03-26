package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;
import pojo.Goodsinfo;

/** 
 * @author Lucifer 
 * @date 2017年3月20日 下午8:50:31 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return
 * 拍卖流程管理  
 */
public interface AuctionProcessManager {
	//发布拍卖
	public boolean onSale(Goods goods,Goodsinfo goodsInfo) throws HibernateException;
	//参与拍卖
	public boolean joinAuction(Goods goods) throws HibernateException;
	//查看竞拍列表
	public List<?> getAuctionList(Goods goods) throws HibernateException;
}
