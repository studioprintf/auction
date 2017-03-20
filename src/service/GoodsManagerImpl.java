package service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import daoImpl.GoodsDaoImpl;
import daoImpl.GoodsinfoDaoImpl;
import pojo.Goods;
import pojo.Goodsinfo;

/** 
 * @author Lucifer 
 * @date 2017年3月16日 下午8:33:53 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
@Service
public class GoodsManagerImpl implements GoodsManager {
	private GoodsDaoImpl goodsDao;
	private GoodsinfoDaoImpl goodsInfoDao;
	
	public GoodsDaoImpl getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDaoImpl goodsDao) {
		this.goodsDao = goodsDao;
	}

	public GoodsinfoDaoImpl getGoodsInfoDao() {
		return goodsInfoDao;
	}

	public void setGoodsInfoDao(GoodsinfoDaoImpl goodsInfoDao) {
		this.goodsInfoDao = goodsInfoDao;
	}

	@Override
	public List<?> searchGoods(Goodsinfo goodsinfo) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateGoodsInfo(Goods goods) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> getGoodsInfo(Goods goods) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getOnSaleGoods() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteGoods(Goods goods) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

}
