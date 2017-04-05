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

    //参加拍卖
    public boolean joinAuction(User user, Goods goods, Auction auction) throws HibernateException;

    //获取拍卖列表
    public List<?> getAuctionList(Goods goods) throws HibernateException;

    //检查保证金
    public Boolean checkMargin(User user,Goods goods) throws HibernateException;

    //生成订单
    public Boolean createOrder(Goods goods) throws HibernateException;
}
