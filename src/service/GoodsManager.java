package service;

import org.hibernate.HibernateException;
import pojo.Goods;
import pojo.Goodsinfo;

import java.util.List;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��15�� ����4:18:25
 * @parameter
 * @return
 */
public interface GoodsManager {
    //搜索商品
    List<?> searchGoods(String searchKey,int index) throws HibernateException;

    //更新商品状态
    boolean updateGoodsState(Goods goods) throws HibernateException;

    //更新商品信息
    boolean updateGoodsInfo(Goodsinfo goodsinfo) throws HibernateException;

    //获取商品信息
    Goods getGoods(Goods goods) throws HibernateException;

    //获取商品详细信息
    Goodsinfo getGoodsInfo(Goods goods) throws HibernateException;

    //获取在售商品
    List<?> getOnSaleGoods() throws HibernateException;

    //删除商品
    boolean deleteGoods(Goods goods) throws HibernateException;

    //用户在售商品
    List<?> userOnSaleGoods(Goods goods) throws HibernateException;

    //检测商品状态
    public String checkState (Goods goods)throws HibernateException;

}
