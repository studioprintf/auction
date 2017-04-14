package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.*;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��20�� ����8:50:31
 * @parameter
 * @return �������̹���
 */
public interface AuctionProcessManager {
    //商品上架
    public boolean onSale(Goods goods, Goodsinfo goodsInfo) throws HibernateException;

    //拍卖出价
    public boolean joinAuction(User user, Goods goods, Auction auction) throws HibernateException;


    //获取拍卖列表
    public List<?> getAuctionList(Goods goods) throws HibernateException;

    //生成订单
    public Boolean createOrder(Goods goods) throws HibernateException;

    //获取出价记录
    public List<?> getBidsList (String goods_id, int index,int numPerPage)throws HibernateException;

    //获取出价记录页数
    public int getBidsNum(Goods goods , String numPerPage)throws HibernateException;

    //获取当前最高价
    public String getMaxPrice (Goods goods) throws HibernateException;



}
