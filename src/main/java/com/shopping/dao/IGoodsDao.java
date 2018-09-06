package com.shopping.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.model.Goods;

public interface IGoodsDao {

	public int addGoods(Goods goods);

	public int updateGoods(Goods goods);

	public int deleteGoods(int goodsId);

	public List<Goods> listAllGoods();

	public Goods getGoodsByGoodsId(int goodsId);

	public int getSurplusByGoodsId(int goodsId);

	public int updateSurplus(@Param("goodsId") int goodsId, @Param("seckillTime") Date date);

	public int updateStatus(@Param("goodsId") int goodsId, @Param("status") int status);

}
