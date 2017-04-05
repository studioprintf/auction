package action.auction;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;
import pojo.Goods;
import pojo.Goodsinfo;
import service.AuctionProcessManagerImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * @author Lucifer
 * @version 1.0
 * @date 2017��3��17�� ����8:18:05
 * @parameter
 * @return
 */
@Controller
public class UserCreateGoodsAction implements Action, SessionAware {
    //��Ʒ��Ϣ
    private int create_user;
    private Double reserve_price;
    private Double limit;
    private String start;//unformatted
    private String end;//unformatted
    //    private Timestamp start_time;
//    private Timestamp final_time;
    //��Ʒ��ϸ��Ϣ
    private String goods_title;
    private String goods_describe;
    private String goods_image1;
    private String goods_image2;
    private String goods_image3;
    private String goods_image4;
    private String goods_image5;


    private AuctionProcessManagerImpl apm;
    private Map<String, Object> session;


    public int getCreate_user() {
        return create_user;
    }



    public void setCreate_user(int create_user) {
        this.create_user = create_user;
    }

    public Double getReserve_price() {
        return reserve_price;
    }

    public void setReserve_price(Double reserve_price) {
        this.reserve_price = reserve_price;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
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




    public AuctionProcessManagerImpl getApm() {
        return apm;
    }

    public void setApm(AuctionProcessManagerImpl apm) {
        this.apm = apm;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        // TODO Auto-generated method stub
        this.session = session;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("GET CREATE GOODS REQUEST.");
        System.out.println(getReserve_price());
        System.out.println(getGoods_title());
        System.out.println(getCreate_user());
        System.out.println(getGoods_describe());
        System.out.println(getGoods_image1());
        System.out.println(getLimit());
        System.out.println(getStart());
        System.out.println(getEnd());
        int user_id;
        //testing
//        if (session.get("USER_NAME") == null && session.get("USER_ID") == null)
//            return NONE;
//        user_id = Integer.parseInt((String) session.get("USER_ID"));
        Goods goods = new Goods();
        Goodsinfo goodsinfo = new Goodsinfo();
//        goods.setCreate_user(user_id);
        goods.setCreate_user(1);
        goods.setReserve_price(reserve_price);
        goods.setLimit_price(limit);
        Timestamp start_time = Timestamp.valueOf(start);
        Timestamp final_time = Timestamp.valueOf(end);
        System.out.println("start_time"+start_time);
        System.out.println("final_tine"+final_time);
        goods.setStart_time(start_time);
        goods.setFinal_time(final_time);
        Timestamp create_time = new Timestamp(System.currentTimeMillis());
        goods.setCreate_time(create_time);
        System.out.println("now"+create_time);
        goods.setState("-1");

        goodsinfo.setGoods_title(goods_title);
        goodsinfo.setGoods_describe(goods_describe);
        goodsinfo.setGoods_image1(goods_image1);
        if (goods_image2!=null){
            goodsinfo.setGoods_image2(goods_image2);
        }if (goods_image3!=null){
            goodsinfo.setGoods_image3(goods_image3);
        }if (goods_image4!=null){
            goodsinfo.setGoods_image4(goods_image4);
        }if (goods_image5!=null){
            goodsinfo.setGoods_image5(goods_image5);
        }



        apm.onSale(goods, goodsinfo);

        return SUCCESS;

    }


}
