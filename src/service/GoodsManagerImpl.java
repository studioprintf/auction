package service;

import daoImpl.GoodsDaoImpl;
import daoImpl.GoodsinfoDaoImpl;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import pojo.Goods;
import pojo.Goodsinfo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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

    @Override//获取商品状态
    public String checkState(Goods goods) throws HibernateException {
        List<?> list= goodsDao.checkState(goods);
        if(list.isEmpty()){
            return null;
        }
        String state = (String) list.get(0);
        return state;
    }

    @Override//获取商品总数
    public int onSaleNum() throws HibernateException {
        int num = 0;
        List<?> amount = goodsDao.getGoodsNum();
        if (!amount.isEmpty()) {
            num = Integer.parseInt(String.valueOf(amount.get(0)));
        }
        return num;
    }

    @Override//按页获取商品列表
    public HashMap<String, List> getGoodsList(int index, int numPerPage) throws HibernateException {
        List<?> list = goodsDao.getGoodsList(index, numPerPage);
        List<Goods> goodsList = new LinkedList<>();
        List<Goodsinfo> goodsinfosList = new LinkedList<>();
        List<String> maxpriceList = new LinkedList<>();
        HashMap<String, List> infoList = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Object[] object = (Object[]) list.get(i);
            Goods goods = new Goods();
            Goodsinfo goodsinfo = new Goodsinfo();
            int goods_id = (int) object[0];
            String state = (String) object[1];
            Timestamp create_time = (Timestamp) object[2];
            Timestamp start_time = (Timestamp) object[3];
            Timestamp final_time = (Timestamp) object[4];
            String goods_title = (String) object[5];
            String goods_image1 = (String) object[6];
            double price = 0;
            if (!(object[7] == null)) {
                price = (double)object[7];
            }



            goods.setGoods_id(goods_id);
            goods.setState(state);
            goods.setCreate_time(create_time);
            goods.setStart_time(start_time);
            goods.setFinal_time(final_time);
            goodsinfo.setGoods_title(goods_title);
            goodsinfo.setGoods_image1(goods_image1);

            goodsList.add(goods);
            goodsinfosList.add(goodsinfo);
            maxpriceList.add(String.valueOf(price));
        }
        infoList.put("Goods", goodsList);
        infoList.put("GoodsInfo", goodsinfosList);
        infoList.put("maxPrice",maxpriceList);
        return infoList;

    }

}
