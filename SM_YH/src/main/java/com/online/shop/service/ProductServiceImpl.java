package com.online.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.OptionVO;
import com.online.shop.domain.ProductVO;
import com.online.shop.persistence.ProductDAO;

@Service // 스프링 프레임워크에 Service 계층 콤포넌트 bean 객체로 등록
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;
	
	@Override
	public int createProduct(ProductVO pVo) {
		
		return productDao.insertProduct(pVo);
	}
	
	@Override
	public int readProductNo(String s_id) {
		
		return productDao.selectProductNo(s_id);
	}

	@Override
	public int createOption(OptionVO oVo) {
		
		return productDao.insertOption(oVo);
	}

	@Override
	public int createImage(ImageVO iVo) {
		
		return productDao.insertImage(iVo);
	}

	@Override
	public ProductVO readUpdateByPno(int p_no) {
		
		return productDao.selectUpdateByPno(p_no);
	}

	@Override
	public List<OptionVO> readOptionByPno(int p_no) {
		
		return productDao.selectOptionByPno(p_no);
	}

} // end class ProductServiceImpl
