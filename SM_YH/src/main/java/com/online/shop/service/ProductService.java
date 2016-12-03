package com.online.shop.service;

import java.util.List;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.OptionVO;
import com.online.shop.domain.ProductVO;

// CRUD: Create, Read, Update, Delete
public interface ProductService {

	// 새 상품 등록
	// 상품 정보 등록 기능
	public abstract int createProduct(ProductVO pVo);
	// 상품 번호 추출 기능
	public abstract int readProductNo(String s_id);
	// 옵션 정보 등록 기능
	public abstract int createOption(OptionVO oVo);
	// 이미지 정보 등록 기능
	public abstract int createImage(ImageVO iVo);
	// 업데이트를 위한 해당 상품번호의 상품 불러오기
	public abstract ProductVO readUpdateByPno(int p_no);
	// 업데이트를 위행 해당 상품번호의 옵션 불러오기
	public abstract List<OptionVO> readOptionByPno(int p_no);
	
} // end interface ProductService
