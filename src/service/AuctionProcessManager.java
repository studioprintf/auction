package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Goods;
import pojo.Goodsinfo;

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
    public boolean joinAuction(Goods goods) throws HibernateException;

    //获取拍卖列表
    public List<?> getAuctionList(Goods goods) throws HibernateException;

    //缴纳保证金
}
