package com.shopping.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.dao.IGoodsDao;
import com.shopping.dao.IOrderDao;
import com.shopping.exception.SeckillCloseException;
import com.shopping.exception.SeckillException;
import com.shopping.exception.SeckillRepeatedException;
import com.shopping.model.Order;
import com.shopping.model.Status;

@Service
public class SeckillService {

	@Resource
	private IGoodsDao goodsDao;

	@Resource
	private IOrderDao orderDao;

	@Transactional
	public String seckillExcetion(int goodsId, String userName) 
			throws SeckillCloseException, SeckillException, SeckillRepeatedException{

		// 减少库存
		try {
			int updateCount = goodsDao.updateSurplus(goodsId, new Date());
			if (updateCount <= 0) {
				throw new SeckillCloseException("秒杀结束");
			} else {
				Order order = new Order(goodsId, userName, new Date(), 1);
				int insertCount = orderDao.addOrder(order);
				if (insertCount <= 0) {
					throw new SeckillRepeatedException("重复秒杀");
				} else {
					return new Status(true, "秒杀成功").toString();
				}
			}
		} catch (SeckillCloseException e) {
			throw e;
		} catch (SeckillRepeatedException e) {
			throw e;
		} catch (Exception e) {
			throw new SeckillException("seckill inner error" + e.getMessage());
		}
	}

}
