package service;

import java.sql.Timestamp;
import java.util.List;

import daoImpl.AuctionDaoImpl;
import daoImpl.GoodsDaoImpl;
import daoImpl.GoodsinfoDaoImpl;
import org.hibernate.HibernateException;

import pojo.Auction;
import pojo.Goods;
import pojo.Goodsinfo;
import pojo.User;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��20�� ����9:20:48
 * @parameter
 * @return
 */
public class AuctionProcessManagerImpl implements AuctionProcessManager {
    private GoodsDaoImpl goodsDao;
    private GoodsinfoDaoImpl goodsinfoDao;
    private AuctionDaoImpl auctionDao;

    public AuctionDaoImpl getAuctionDao() {
        return auctionDao;
    }

    public void setAuctionDao(AuctionDaoImpl auctionDao) {
        this.auctionDao = auctionDao;
    }

    public GoodsDaoImpl getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDaoImpl goodsDao) {
        this.goodsDao = goodsDao;
    }

    public GoodsinfoDaoImpl getGoodsinfoDao() {
        return goodsinfoDao;
    }

    public void setGoodsinfoDao(GoodsinfoDaoImpl goodsinfoDao) {
        this.goodsinfoDao = goodsinfoDao;
    }

    @Override
    public boolean onSale(Goods goods, Goodsinfo goodsinfo) throws HibernateException {
        // TODO Auto-generated method stub
        goodsDao.saveGoods(goods);
        goodsinfoDao.saveInfo(goodsinfo);
        return true;
    }

    @Override
    public boolean joinAuction(User user, Goods goods, Auction auction) throws HibernateException {
        // TODO Auto-generated method stub
        goods = (Goods) goodsDao.searchGoods(goods).get(0);
        //获取拍卖物品的信息
        if(!goods.getState().equals("在售"))
            //判断商品状态
            return false;
        Auction auction1Sql = (Auction) auctionDao.findMaxLog(goods).get(0);
        //获取拍卖记录中的最高价记录
        if(auction.getPrice()>auction1Sql.getPrice()&&(auction.getPrice()-goods.getReserve_price())%goods.getLimit()==0) {
            //出价是否大于最高价且出价是否为涨幅的整数倍
            auction.setUser_id(user.getUser_id());
            auction.setCreate_time(new Timestamp(System.currentTimeMillis()));
            auctionDao.saveLog(auction);
            return true;
        }
        return false;
    }

    @Override
    public List<?> getAuctionList(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean checkMargin(User user, Goods goods) throws HibernateException {
        List<?> result = auctionDao.findLog(user,goods);
        if(result.size()==0)
            return true;
        return false;
    }

}
