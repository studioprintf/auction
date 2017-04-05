package dao;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;

public interface GoodsDao {
    boolean saveGoods(Goods goods) throws HibernateException;

    List<?> getAll() throws HibernateException;

    List<?> searchGoods(Goods goods) throws HibernateException;

    boolean updateGoods(Goods goods) throws HibernateException;

    List<?> searchGoodsHour() throws  HibernateException;

    List<?> searchOnsaleGoodsHour() throws HibernateException;
}
