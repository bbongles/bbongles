package com.online.shop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		// 전체 상품 리스트를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("productList", productList);
		
	} // end sellerHome() -> 판매자 홈에서 상품 리스트를 보여주는 역할
	
	@RequestMapping(value="pDetail", method=RequestMethod.GET)
	public void productDetail(int p_no, Model model) {
		// 상품 번호에 의한 각 상품의 전체 정보 받아오기
		ProductVO pVo = sellerService.readItemByPno(p_no);
		// 전체 정보를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("productVO", pVo);
		
	} // end productDetail() -> 판매자 홈에서 상품 번호를 참조해 상품 상세 페이지로 넘겨주는 역할 
	
} // end class SellerController
