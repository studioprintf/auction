package pojo;

import java.sql.Timestamp;

public class Goods {
	private int goods_id;
	private int create_user;
	private String state;
	private Double reserve_price;
	private Double limit;
	private Timestamp create_time;
	private Timestamp start_time;
	private Timestamp final_time;
	private Timestamp final_price;
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
	public Timestamp getFinal_price() {
		return final_price;
	}
	public void setFinal_price(Timestamp final_price) {
		this.final_price = final_price;
	}
	
}
