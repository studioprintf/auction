package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;
import pojo.Goodsinfo;

/** 
 * @author Lucifer 
 * @date 2017年3月15日 下午4:18:25 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public interface GoodsManager {
	//搜索商品
	public List<?> searchGoods(Goodsinfo goodsinfo) throws HibernateException;
	//更新商品信息
	public boolean updateGoodsInfo(Goods goods) throws HibernateException;
	//查看商品信息
	public List<?> getGoodsInfo(Goods goods) throws HibernateException;
	//查看正在拍卖的商品
	public List<?> getOnSaleGoods() throws HibernateException;
	//删除商品
	public boolean deleteGoods(Goods goods) throws HibernateException; 
}
