package dao;

import org.hibernate.HibernateException;
import pojo.Auction;
import pojo.Goods;
import pojo.User;

import java.util.List;

public interface AuctionDao {
    //查找某个人某件商品的拍卖记录
    List<?> findLog(User user, Goods goods) throws HibernateException;
    //查找某件商品的拍卖记录
    List<?> findGoodsLog(Goods goods) throws HibernateException;
    //查找某件商品最高价记录
    List<?> findMaxLog(Goods goods) throws HibernateException;
    //存入竞拍记录
    Boolean saveLog(Auction auction) throws HibernateException;

    //获取对应商品的出价记录数
    int getBidsNum(Goods goods) throws HibernateException;

    //分页获取出价记录
    public List<?> getBids(String goods_id, int offset, int length) throws HibernateException;

    //根据goods_id获取出价记录
    List<?> getBidList(String goods_id) throws HibernateException;



}
