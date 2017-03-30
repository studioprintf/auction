package service;

import java.util.List;

import daoImpl.GoodsDaoImpl;
import daoImpl.GoodsinfoDaoImpl;
import org.hibernate.HibernateException;

import pojo.Goods;
import pojo.Goodsinfo;

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
        return false;
    }

    @Override
    public boolean joinAuction(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<?> getAuctionList(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        return null;
    }

}
