package dao;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;

public interface GoodsDao {
    boolean saveGoods(Goods goods) throws HibernateException;

    List<?> getAll() throws HibernateException;

    List<?> searchGoodsByUser(Goods goods) throws HibernateException;

    List<?> fingGoodsInfo(Goods goods) throws HibernateException;

    List<?> searchOnSale() throws HibernateException;

    boolean updateGoods(Goods goods) throws HibernateException;

    List<?> searchGoodsHour() throws  HibernateException;

    List<?> searchOnsaleGoodsHour() throws HibernateException;

    //查看商品状态
    List<?> checkState(Goods goods) throws HibernateException;
}
