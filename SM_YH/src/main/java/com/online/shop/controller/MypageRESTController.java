package com.online.shop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.online.shop.domain.CartandBuy;
import com.online.shop.service.BuyerService;

@RestController
@RequestMapping(value="/userid")
public class MypageRESTController { 
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private BuyerService buyerservice;
	
	@RequestMapping(value="all/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<CartandBuy>> readBuy(@PathVariable("id") String b_id){
		logger.info("b_id = " + b_id);
		List<CartandBuy> list = buyerservice.read(b_id);
		logger.info("List.count : " + list.get(0).getCount());
		
		ResponseEntity<List<CartandBuy>> entity = null;
		if (list != null){
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} 
		return entity;
	} 
	
	
}
