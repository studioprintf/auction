package action.seller;

import action.BaseAction;
import pojo.Goods;
import pojo.Goodsinfo;
import service.AuctionProcessManagerImpl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DTLuc on 2017/3/30.
 */
public class SellerOnSaleAction extends BaseAction{
    private int create_user;
    private String state;
    private double reserve_price;
    private double limit;
    private Timestamp start_time;
    private Timestamp final_time;
    private Goods goods;

    private String goods_title;
    private String goods_describe;
    private String goods_image1;
    private String goods_image2;
    private String goods_image3;
    private String goods_image4;
    private String goods_image5;
    private String goods_image6;
    private Goodsinfo goodsinfo;

    private AuctionProcessManagerImpl auctionProcessManager;

    public AuctionProcessManagerImpl getAuctionProcessManager() {
        return auctionProcessManager;
    }

    public void setAuctionProcessManager(AuctionProcessManagerImpl auctionProcessManager) {
        this.auctionProcessManager = auctionProcessManager;
    }

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public String getGoods_describe() {
        return goods_describe;
    }

    public void setGoods_describe(String goods_describe) {
        this.goods_describe = goods_describe;
    }

    public String getGoods_image1() {
        return goods_image1;
    }

    public void setGoods_image1(String goods_image1) {
        this.goods_image1 = goods_image1;
    }

    public String getGoods_image2() {
        return goods_image2;
    }

    public void setGoods_image2(String goods_image2) {
        this.goods_image2 = goods_image2;
    }

    public String getGoods_image3() {
        return goods_image3;
    }

    public void setGoods_image3(String goods_image3) {
        this.goods_image3 = goods_image3;
    }

    public String getGoods_image4() {
        return goods_image4;
    }

    public void setGoods_image4(String goods_image4) {
        this.goods_image4 = goods_image4;
    }

    public String getGoods_image5() {
        return goods_image5;
    }

    public void setGoods_image5(String goods_image5) {
        this.goods_image5 = goods_image5;
    }

    public String getGoods_image6() {
        return goods_image6;
    }

    public void setGoods_image6(String goods_image6) {
        this.goods_image6 = goods_image6;
    }

    public Goodsinfo getGoodsinfo() {
        return goodsinfo;
    }

    public void setGoodsinfo(Goodsinfo goodsinfo) {
        this.goodsinfo = goodsinfo;
    }

    public int getCreate_user() {
        return create_user;
    }

    public void setCreate_user(int create_user) {
        this.create_user = create_user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getReserve_price() {
        return reserve_price;
    }

    public void setReserve_price(double reserve_price) {
        this.reserve_price = reserve_price;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getFinal_time() {
        return final_time;
    }

    public void setFinal_time(Timestamp final_time) {
        this.final_time = final_time;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start_time);
        //将设置开始时间转成calendar
        calendar.add(Calendar.HOUR,1);
        //开始时间+1小时
        if(nowTime.after(start_time)||final_time.before(calendar.getTime())) {
            //判断开始时间是否在现在时间之后
            //判断结束时间是否在开始时间之后的一个小时
            return ERROR;
        }
        goods = new Goods();
        goods.setCreate_user(Integer.parseInt(session.get("USER_ID").toString()));
        goods.setState("等待");
        goods.setReserve_price(reserve_price);
        goods.setLimit(limit);
        goods.setCreate_time(nowTime);
        goods.setStart_time(start_time);
        goods.setFinal_time(final_time);

        goodsinfo.setGoods_title(getGoods_title());
        goodsinfo.setGoods_describe(getGoods_describe());
        goodsinfo.setGoods_image1(getGoods_image1());
        if(getGoods_image2()!=null) {
            goodsinfo.setGoods_image2(getGoods_image2());
            if(getGoods_image3()!=null) {
                goodsinfo.setGoods_image2(getGoods_image2());
                if (getGoods_image4() != null) {
                    goodsinfo.setGoods_image2(getGoods_image2());
                    if (getGoods_image5() != null) {
                        goodsinfo.setGoods_image2(getGoods_image2());
                        if (getGoods_image6() != null) {
                            goodsinfo.setGoods_image2(getGoods_image2());
                        }
                    }
                }
            }
        }
        if(auctionProcessManager.onSale(goods,goodsinfo))
            return SUCCESS;
        else
            return ERROR;
    }
}
