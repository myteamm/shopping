package com.shopping.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.model.Goods;
import com.shopping.service.GoodsService;

@Controller
@RequestMapping(value = "/goods")
@CrossOrigin(origins = "*")
public class GoodsController {

	@Resource
	private GoodsService goodsService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String list() {
		return goodsService.list();
	}

	@RequestMapping(value = "/{goodsId}/detail", method = RequestMethod.GET)
	@ResponseBody
	public String detail(@PathVariable(value = "goodsId") int goodsId) {
		System.out.println(goodsService.detail(goodsId));
		return goodsService.detail(goodsId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(Goods goods) {
		return goodsService.add(goods);
	}

}
