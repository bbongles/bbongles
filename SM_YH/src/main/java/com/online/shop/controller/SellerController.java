package com.online.shop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.ProductVO;
import com.online.shop.service.ProductService;
import com.online.shop.service.SellerService;

@Controller // 스프링 프레임워크에 Controller bean 객체로 등록
@RequestMapping(value="/seller")
public class SellerController {

	private static final Logger logger = 
			LoggerFactory.getLogger(ProductController.class);
	
	@Autowired 
	ProductService productService;
	
	@Autowired
	SellerService sellerService;
	
	@RequestMapping(value="/pList", method=RequestMethod.GET)
	public void sellerHome(Model model) {
		// 전체 상품 리스트
		List<ProductVO> productList = sellerService.readAllProduct();
		List<ImageVO> imageList = sellerService.readMainImage();
		// 전체 상품 리스트를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("productList", productList);
		model.addAttribute("imageList", imageList);
	}
	
} // end class SellerController
