package pojo;

import java.sql.Timestamp;

public class Goods {
    /**
     *
     */
    private int goods_id;
    private int create_user;
    private String state;
    private double reserve_price;
    private double limit_price;
    private Timestamp create_time;
    private Timestamp start_time;
    private Timestamp final_time;
    private double final_price;

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
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

    public double getLimit_price() {
        return limit_price;
    }

    public void setLimit_price(double limit_price) {
        this.limit_price = limit_price;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
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

    public double getFinal_price() {
        return final_price;
    }

    public void setFinal_price(double final_price) {
        this.final_price = final_price;
    }
}
