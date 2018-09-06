package com.shopping.dao;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring.xml" })
@Transactional
public class GoodsDaoTest {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource
	private IGoodsDao goodsDao;

	@Test
	public void test() throws ParseException {
		Goods goods = new Goods();
		goods.setDescription("description");
		goods.setImageUrl("imageUrl");
		goods.setMarketPrice(299.00);
		goods.setSeckillPrice(1.00);
		goods.setStartTime(sdf.parse("2018-8-8 10:00:00"));
		goods.setEndTime(sdf.parse("2018-8-8 11:00:00"));
		goods.setStatus(0);
		goods.setSurplus(100);
		goods.setTotality(100);

		assertEquals(1, goodsDao.addGoods(goods));

		assertEquals(3, goodsDao.listAllGoods().size());

		Goods g1 = goodsDao.getGoodsByGoodsId(goods.getGoodsId());

		assertEquals("description", g1.getDescription());
		assertEquals("imageUrl", g1.getImageUrl());
		assertEquals("2018-08-08 10:00:00", sdf.format(g1.getStartTime()));
		assertEquals(0, g1.getStatus());
		assertEquals(100, g1.getSurplus());

		assertEquals(100, goodsDao.getSurplusByGoodsId(goods.getGoodsId()));

		goodsDao.updateStatus(goods.getGoodsId(), 1);
		assertEquals(1, goodsDao.updateSurplus(goods.getGoodsId(), sdf.parse("2018-8-8 10:30:00")));
		
		g1 = goodsDao.getGoodsByGoodsId(goods.getGoodsId());
		assertEquals(1, g1.getStatus());
		assertEquals(99, g1.getSurplus());
		
		goods.setDescription("desc");
		goods.setImageUrl("imgUrl");
		goods.setStartTime(sdf.parse("2019-08-08 10:00:00"));
		goods.setTotality(66);

		assertEquals(1, goodsDao.updateGoods(goods));

		g1 = goodsDao.getGoodsByGoodsId(goods.getGoodsId());

		assertEquals("desc", g1.getDescription());
		assertEquals("imgUrl", g1.getImageUrl());
		assertEquals("2019-08-08 10:00:00", sdf.format(g1.getStartTime()));
		assertEquals(66, g1.getTotality());
		
		assertEquals(1, goodsDao.deleteGoods(goods.getGoodsId()));
	}

}
