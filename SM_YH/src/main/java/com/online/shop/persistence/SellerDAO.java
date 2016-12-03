package com.online.shop.persistence;

import java.util.List;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.OptionVO;
import com.online.shop.domain.ProductVO;
import com.online.shop.domain.SellerVO;

public interface SellerDAO {

	public abstract List<ProductVO> selectAllProduct();
	public abstract ProductVO selectItemByPno(int p_no);
	public abstract List<OptionVO> selectOpByPno(int p_no);
	public abstract List<ImageVO> selectImgByPno(int p_no);
	public abstract int updateLogo(SellerVO sVo);
	public abstract SellerVO selectSellerInfo(String s_id);
	public abstract int updateInfo(SellerVO sVo);
	
} // end interface SellerDAO
