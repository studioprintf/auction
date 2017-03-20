package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;
import pojo.Goodsinfo;

/** 
 * @author Lucifer 
 * @date 2017年3月20日 下午9:20:48 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class AuctionProcessManagerImpl implements AuctionProcessManager {

	@Override
	public boolean onSale(Goods goods,Goodsinfo goodsinfo) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean joinAuction(Goods goods) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> getAuctionList(Goods goods) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
