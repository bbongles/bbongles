package com.online.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.ProductVO;
import com.online.shop.persistence.SellerDAO;

@Service // 스프링 프레임워크에 Service 계층 콤포넌트 bean 객체로 등록
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDAO sellerDao;
	
	@Override
	public List<ProductVO> readAllProduct() {
		
		return sellerDao.selectAllProduct();
	}

	@Override
	public ProductVO readItemByPno(int p_no) {
		
		return sellerDao.selectItemByPno(p_no);
	}

} // end class SellerServiceImpl
