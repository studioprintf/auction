package pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Goods implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int goods_id;
    private int create_user;
    private String state;
    private double reserve_price;
    private double limit;
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

    public void setFinal_price(double final_price) {
        this.final_price = final_price;
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

    public double getFinal_price() {
        return final_price;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public void setFinal_time(Timestamp final_time) {
        this.final_time = final_time;
    }


}
