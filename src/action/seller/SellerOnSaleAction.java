package action.seller;

import action.BaseAction;
import pojo.Goods;
import pojo.Goodsinfo;
import service.AuctionProcessManagerImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by DTLuc on 2017/3/30.
 */
public class SellerOnSaleAction extends BaseAction{
    private double reserve_price;
    private double limit;
    private String start;//unformatted
    private String end;//unformatted
    private Goods goods;



    private String goods_title;
    private String goods_describe;
    private String goods_image1;
    private String goods_image2;
    private String goods_image3;
    private String goods_image4;
    private String goods_image5;
    private Goodsinfo goodsinfo;
    private InputStream inputStream;

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


    public Goodsinfo getGoodsinfo() {
        return goodsinfo;
    }

    public void setGoodsinfo(Goodsinfo goodsinfo) {
        this.goodsinfo = goodsinfo;
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


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        Timestamp start_time;
        Timestamp nowTime;
        Timestamp final_time;

        goods = new Goods();
        goodsinfo = new Goodsinfo();

        nowTime = new Timestamp(System.currentTimeMillis());
        final_time = Timestamp.valueOf(end);

        if(start.equals("0")) {//立刻上架
            start_time = nowTime;
            goods.setState("1");
        }else {//设定上架时间
            start_time = Timestamp.valueOf(start);
            goods.setState("0");
        }



        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start_time);
        //将设置开始时间转成calendar
        calendar.add(Calendar.HOUR,1);
        //开始时间+1小时

        if(nowTime.after(start_time)||final_time.before(calendar.getTime())) {
            //判断开始时间是否在现在时间之后
            //判断结束时间是否在开始时间之后的一个小时

            inputStream = new ByteArrayInputStream("时间戳校验失败,结束时间要晚于开始时间至少一个小时".getBytes("UTF-8"));
        } else {


//        goods.setCreate_user(Integer.parseInt(session.get("USER_ID").toString()));


            goods.setCreate_user(1);
            goods.setReserve_price(getReserve_price());
            goods.setLimit_price(getLimit());
            goods.setCreate_time(nowTime);
            goods.setStart_time(start_time);
            goods.setFinal_time(final_time);


            goodsinfo.setGoods_title(getGoods_title());
            goodsinfo.setGoods_describe(getGoods_describe());
            goodsinfo.setGoods_image1(getGoods_image1());
            if (getGoods_image2() != null) {
                goodsinfo.setGoods_image2(getGoods_image2());
                if (getGoods_image3() != null) {
                    goodsinfo.setGoods_image2(getGoods_image2());
                    if (getGoods_image4() != null) {
                        goodsinfo.setGoods_image2(getGoods_image2());
                        if (getGoods_image5() != null) {
                            goodsinfo.setGoods_image2(getGoods_image2());
                        }
                    }
                }
            }
//            goods.setFinal_price(-1);
            if (auctionProcessManager.onSale(goods, goodsinfo)&&auctionProcessManager.saveInfo(goodsinfo))
                inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
            else
                inputStream = new ByteArrayInputStream("服务器错误".getBytes("UTF-8"));
        }
        return SUCCESS;
    }
}
