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

import com.shopping.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring.xml" })
@Transactional
public class OrderDaoTest {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource
	private IOrderDao orderDao;

	@Resource
	private IGoodsDao goodsDao;

	@Test
	public void test() throws ParseException {

		Order order = new Order();
		order.setGoodsId(34);
		order.setUserName("user");
		order.setStatus(1);
		order.setCreateTime(sdf.parse("2018-8-8 11:00:00"));

		assertEquals(0, orderDao.addOrder(order));
		
		assertEquals(2, orderDao.listByUserName("user").size());
		
		assertEquals(2, orderDao.listAll().size());
		
		System.out.println(orderDao.listAll().get(0).getGoods());

	}
}
