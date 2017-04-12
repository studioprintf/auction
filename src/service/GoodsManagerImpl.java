package service;

import daoImpl.GoodsDaoImpl;
import daoImpl.GoodsinfoDaoImpl;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import pojo.Goods;
import pojo.Goodsinfo;

import java.util.List;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��16�� ����8:33:53
 * @parameter
 * @return
 */
@Service
public class GoodsManagerImpl implements GoodsManager {
    private GoodsDaoImpl goodsDao;
    private GoodsinfoDaoImpl goodsInfoDao;

    public GoodsDaoImpl getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDaoImpl goodsDao) {
        this.goodsDao = goodsDao;
    }

    public GoodsinfoDaoImpl getGoodsInfoDao() {
        return goodsInfoDao;
    }

    public void setGoodsInfoDao(GoodsinfoDaoImpl goodsInfoDao) {
        this.goodsInfoDao = goodsInfoDao;
    }

    @Override
    public List<?> searchGoods(String searchKey,int index) throws HibernateException {
        // TODO Auto-generated method stub
        int num = Integer.parseInt(goodsInfoDao.getGoodsNum(searchKey).get(0).toString());
        if(num%10==0&&num/10<=index+1) //判断结果是否在最后一页完全显示且输入的页码是否比最大页码小
            index = 0;
        else if(num%10!=0&&num/10<=index+2)
            index = 0;
        List<?> result = goodsInfoDao.getGoodsInfo(searchKey,index);
        index = num;
        return result;
    }

    @Override
    public boolean updateGoodsState(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        goodsDao.updateGoods(goods);
        return false;
    }

    @Override
    public boolean updateGoodsInfo(Goodsinfo goodsinfo) throws HibernateException {
        if (goodsInfoDao.updateInfo(goodsinfo))
            return true;
        return false;
    }

    @Override
    public Goodsinfo getGoodsInfo(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        List<?> list = goodsDao.fingGoodsInfo(goods);
        if (!list.isEmpty()) {//修复越界
            goods = (Goods) list.get(0);
            Goodsinfo goodsinfo = goodsInfoDao.findGoodsInfo(goods);
            return goodsinfo;
        } else
            return null;
    }

    public Goods getGoods(Goods goods) throws HibernateException {
        List<?> list = goodsDao.fingGoodsInfo(goods);
        if (!list.isEmpty()) {
            return (Goods) list.get(0);
        }
        return null;
    }

    @Override
    public List<?> getOnSaleGoods() throws HibernateException {
        // TODO Auto-generated method stub
        List onSaleList = goodsDao.searchOnSale();
        return onSaleList;
    }

    @Override
    public boolean deleteGoods(Goods goods) throws HibernateException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<?> userOnSaleGoods(Goods good) throws HibernateException {
        return goodsDao.searchGoodsByUser(good);
    }

}
