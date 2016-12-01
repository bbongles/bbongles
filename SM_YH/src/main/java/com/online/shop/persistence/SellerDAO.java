package com.online.shop.persistence;

import java.util.List;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.ProductVO;

public interface SellerDAO {

	public abstract List<ProductVO> selectAllProduct();
	public abstract ProductVO selectItemByPno(int p_no);
	
} // end interface SellerDAO
