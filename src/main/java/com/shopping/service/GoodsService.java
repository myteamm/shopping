package com.shopping.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.IGoodsDao;
import com.shopping.model.Goods;
import com.shopping.model.Status;

import net.sf.json.JSONArray;

@Service
public class GoodsService {
	
	@Resource
	private IGoodsDao goodsDao;
	
	public String add(Goods goods) {
		int insertCount = goodsDao.addGoods(goods);
		if (insertCount <= 0) {
			return new Status(false, "添加商品失败").toString();
		}
		return new Status(true, "添加商品成功").toString();
	}
	
	public String list() {
		List<Goods> goods = goodsDao.listAllGoods();
		return JSONArray.fromObject(goods).toString();
	}
	
	public String detail(int goodsId) {
		Goods goods = goodsDao.getGoodsByGoodsId(goodsId);
		return goods.toString();
	}
	

}
