package pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Auction implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int auction_id;
    private int goods_id;
    private double price;
    private String user_name;
    private Timestamp create_time;

    public int getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }


}
