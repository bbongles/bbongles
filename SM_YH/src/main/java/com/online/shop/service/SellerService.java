package com.online.shop.service;

import java.util.List;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.ProductVO;

// CRUD: Create, Read, Update, Delete
public interface SellerService {

	// 전체 상품 정보 검색
	public abstract List<ProductVO> readAllProduct();
	// 해당 상품 번호로 상세 페이지 리턴
	public abstract ProductVO readItemByPno(int p_no);
	
} // end interface SellerService
