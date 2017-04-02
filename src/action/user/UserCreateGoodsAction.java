package action.user;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import pojo.Goods;
import pojo.Goodsinfo;
import service.AuctionProcessManagerImpl;

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
    private Timestamp start_time;
    private Timestamp final_time;
    //��Ʒ��ϸ��Ϣ
    private String goods_title;
    private String goods_describe;
    private String goods_image1;
    private String goods_image2;
    private String goods_image3;
    private String goods_image4;
    private String goods_image5;
    private String goods_image6;

    private AuctionProcessManagerImpl apm;
    private Map<String, Object> session;

    public int getCreate_user() {
        return create_user;
    }

    public Timestamp getFinal_time() {
        return final_time;
    }

    public void setFinal_time(Timestamp final_time) {
        this.final_time = final_time;
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

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
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
        int user_id;
        if (session.get("USER_NAME") == null && session.get("USER_ID") == null)
            return NONE;
        user_id = Integer.parseInt((String) session.get("USER_ID"));
        Goods goods = new Goods();
        Goodsinfo goodsinfo = new Goodsinfo();
        goods.setCreate_user(user_id);
        goods.setReserve_price(reserve_price);
        goods.setLimit_price(limit);
        goods.setStart_time(start_time);
        goods.setFinal_time(final_time);
        goods.setCreate_time(new Timestamp(new Date().getTime()));
        apm.onSale(goods, goodsinfo);

        return null;
    }

}
