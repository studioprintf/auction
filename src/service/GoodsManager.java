package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;
import pojo.Goodsinfo;
import pojo.User;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��15�� ����4:18:25
 * @parameter
 * @return
 */
public interface GoodsManager {
    //搜索商品
    public List<?> searchGoods(String searchKey,int index) throws HibernateException;

    //更新商品信息
    public boolean updateGoodsInfo(Goods goods) throws HibernateException;

    //获取商品信息
    public Goodsinfo getGoodsInfo(Goods goods) throws HibernateException;

    //获取在售商品
    public List<?> getOnSaleGoods() throws HibernateException;

    //删除商品
    public boolean deleteGoods(Goods goods) throws HibernateException;

    //用户在售商品
    List<?> userOnSaleGoods(Goods goods) throws HibernateException;
}
