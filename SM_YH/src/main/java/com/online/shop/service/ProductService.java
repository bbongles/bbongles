package com.online.shop.service;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.OptionVO;
import com.online.shop.domain.ProductVO;

// CRUD: Create, Read, Update, Delete
public interface ProductService {

	// 새 상품 등록
	// 상품 정보 등록 기능
	public abstract int createProduct(ProductVO pVo);
	// 옵션 정보 등록 기능
	public abstract int createOption(OptionVO oVo);
	// 이미지 정보 등록 기능
	public abstract int createImage(ImageVO iVo);
	
} // end interface ProductService
