package com.online.shop.persistence;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.OptionVO;
import com.online.shop.domain.ProductVO;

public interface ProductDAO {

	public abstract int insertProduct(ProductVO pVo);
	public abstract int insertOption(OptionVO oVo);
	public abstract int insertImage(ImageVO iVo);
	
} // end interface ProductDAO
