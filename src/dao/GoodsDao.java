package dao;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;

public interface GoodsDao {
    public boolean saveGoods(Goods goods) throws HibernateException;

    public List<?> getAll() throws HibernateException;

    public List<?> searchGoods(Goods goods) throws HibernateException;

    public boolean updateGoods(Goods goods) throws HibernateException;

    public List<?> searchGoodsHour() throws  HibernateException;
}
