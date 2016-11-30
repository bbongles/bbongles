package com.online.shop.service;

import java.util.List;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.ProductVO;

// CRUD: Create, Read, Update, Delete
public interface SellerService {

	// 전체 상품 정보 검색
	public abstract List<ProductVO> readAllProduct();
	// 전체 상품 이미지 검색
	public abstract List<ImageVO> readAllImage();
	
} // end interface SellerService
