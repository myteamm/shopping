package com.shopping.model;

import java.util.Date;

public class Goods {

	private int goodsId;

	private String description;

	private String imageUrl;

	private double seckillPrice;

	private double marketPrice;

	private Date startTime;

	private Date endTime;

	private int status;

	private int totality;

	private int surplus;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getSeckillPrice() {
		return seckillPrice;
	}

	public void setSeckillPrice(double priceSpike) {
		this.seckillPrice = priceSpike;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marktPrice) {
		this.marketPrice = marktPrice;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTotality() {
		return totality;
	}

	public void setTotality(int totality) {
		this.totality = totality;
	}

	public int getSurplus() {
		return surplus;
	}

	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", description=" + description + ", imageUrl=" + imageUrl + ", priceSpike="
				+ seckillPrice + ", marktPrice=" + marketPrice + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", status=" + status + "]";
	}

}
