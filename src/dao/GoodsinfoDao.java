package dao;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;
import pojo.Goodsinfo;

public interface GoodsinfoDao {
    public List<?> getGoodsInfo(Goodsinfo goodsinfo) throws HibernateException;

    public Boolean saveInfo(Goodsinfo goodsinfo) throws HibernateException;

    public Goodsinfo findGoodsInfo(Goods goods) throws HibernateException;
}
