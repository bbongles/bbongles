package com.online.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/mypage")
public class MypageController {

	public static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@RequestMapping(value="buyermypage", method=RequestMethod.GET)
	public void BuyerMypage(){
		
	}
	
	@RequestMapping(value="sellermypage", method=RequestMethod.GET)
	public void SellerMypage(){
		
	}
	
}
