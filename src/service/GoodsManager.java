package service;

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
	public boolean onSale(Goods goods,Goodsinfo goodsinfo) throws HibernateException;
	public boolean unSale(Goods goods) throws HibernateException;
}
