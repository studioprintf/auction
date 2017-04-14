package service;

import daoImpl.AuctionDaoImpl;
import daoImpl.GoodsDaoImpl;
import daoImpl.GoodsinfoDaoImpl;
import daoImpl.User_orderDaoImpl;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import pojo.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��20�� ����9:20:48
 * @parameter
 * @return
 */

@Service
public class AuctionProcessManagerImpl implements AuctionProcessManager {
    private GoodsDaoImpl goodsDao;
    private GoodsinfoDaoImpl goodsinfoDao;
    private AuctionDaoImpl auctionDao;
    private User_orderDaoImpl orderDao;

    public User_orderDaoImpl getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(User_orderDaoImpl orderDao) {
        this.orderDao = orderDao;
    }

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
        goodsinfo.setGoods_id(goods.getGoods_id());
//        goodsinfoDao.saveInfo(goodsinfo);
//        saveInfo(goodsinfo);
        return true;
    }

    public boolean saveInfo(Goodsinfo goodsinfo) throws HibernateException{
        goodsinfoDao.saveInfo(goodsinfo);
        return true;
    }

    @Override
    //拍卖出价
    public boolean joinAuction(User user, Goods goods, Auction auction) throws HibernateException {
        // TODO Auto-generated method stub
        goods = (Goods) goodsDao.fingGoodsInfo(goods).get(0);
        //获取拍卖物品的信息
        if (!goods.getState().equals("1")) {
            //判断商品状态
            return false;
        }

        Auction auction1Sql;
        List<?> list = auctionDao.findMaxLog(goods);


        if(!list.isEmpty()) {//最高价不为空
            auction1Sql = (Auction) auctionDao.findMaxLog(goods).get(0);//获取最高价
            if (!(auction.getPrice() > auction1Sql.getPrice())) {//出价不大于最高价则出价失败//
                return false;
            }
        }
        if (!(auction.getPrice()>goods.getReserve_price())){//判断出价是否大于底价
            return false;
        }
        if((auction.getPrice()-goods.getReserve_price())%goods.getLimit_price()==0) {
            //出价是否为涨幅的整数倍
            auction.setUser_name(user.getUser_name());
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
    public Boolean createOrder(Goods goods) throws HibernateException {
        List<?> auctionList = auctionDao.findMaxLog(goods);
        if(auctionList.isEmpty())
            return false;
        Auction auctionMax = (Auction) auctionList.get(0);
        System.out.println(auctionMax.getPrice());
        User_order order = new User_order();
        order.setGoods_id(goods.getGoods_id());
        order.setCreate_time(new Timestamp(System.currentTimeMillis()));
        order.setPrice(auctionMax.getPrice());
        order.setUser_name(auctionMax.getUser_name());
        order.setState("已下单");
        orderDao.saveOrder(order);
        System.out.println("成功创建订单");
        return true;
    }

    @Override
    public List<?> getBidsList(String goods_id, int index , int numPerPage) throws HibernateException {
        List<?> result = auctionDao.getBids(goods_id, index-1, numPerPage);
        return result;
    }

    @Override//获取出价记录条数
    public int getBidsNum(Goods goods, String numPerPage) throws HibernateException {
        int bidsNum = auctionDao.getBidsNum(goods);//bids num
        int n = Integer.parseInt(numPerPage);
        if (bidsNum == n)
            return bidsNum / n;
        else
            return bidsNum / n+1;
    }

    @Override//获取商品当前最高价
    public String getMaxPrice(Goods goods) throws HibernateException {
        List<Auction> list = (List<Auction>) auctionDao.findMaxLog(goods);
        Auction max;
        if (!(list.isEmpty())) {
            max = list.get(0);
            return String.valueOf(max.getPrice());
        }
        return "";
    }


}
