package dao;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;
import pojo.Goodsinfo;

public interface GoodsinfoDao {

    List<?> getGoodsNum(String searchKey) throws HibernateException;

    List<?> getGoodsInfo(String searchKey,int index) throws HibernateException;

    Boolean saveInfo(Goodsinfo goodsinfo) throws HibernateException;

    Goodsinfo findGoodsInfo(Goods goods) throws HibernateException;
}
