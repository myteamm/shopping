package com.shopping.model;

import java.util.Date;

import net.sf.json.JSONObject;

public class Order {

	private int goodsId;

	private String userName;

	private Date createTime;

	private int status;
	
	public Order() {
		super();
	}

	public Order(int goodsId, String userName, Date createTime, int status) {
		super();
		this.goodsId = goodsId;
		this.userName = userName;
		this.createTime = createTime;
		this.status = status;
	}

	private Goods goods;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int orderId) {
		this.goodsId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}

}
