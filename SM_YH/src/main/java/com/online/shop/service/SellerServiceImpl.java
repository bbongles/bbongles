package com.online.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.OptionVO;
import com.online.shop.domain.ProductVO;
import com.online.shop.domain.SellerVO;
import com.online.shop.pageutil.PageCriteria;
import com.online.shop.pageutil.SearchPageCriteria;
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

	@Override
	public List<OptionVO> readOpByPno(int p_no) {
		
		return sellerDao.selectOpByPno(p_no);
	}

	@Override
	public List<ImageVO> readImgByPno(int p_no) {
		
		return sellerDao.selectImgByPno(p_no);
	}

	@Override
	public int updateLogo(SellerVO sVo) {
		
		return sellerDao.updateLogo(sVo);
	}

	@Override
	public SellerVO readSellerInfo(String s_id) {
		
		return sellerDao.selectSellerInfo(s_id);
	}

	@Override
	public int updateInfo(SellerVO sVo) {
		
		return sellerDao.updateInfo(sVo);
	}
	
	// 관리자 페이지 관련
	@Override
	public List<SellerVO> read() {
		return sellerDao.select();
	}
	
	@Override
	public int getNumOfRecords() {
		return sellerDao.getNumOfRecords();
	}
	
	@Override
	public List<SellerVO> read(PageCriteria cri) {
		return sellerDao.select(cri);
	}
	
	@Override
	public List<SellerVO> listSearchCriteria(SearchPageCriteria cri) {
		return sellerDao.listSearch(cri);
	}
	
	@Override
	public int listSearchCount(SearchPageCriteria cri) {
		return sellerDao.listSearchCount(cri);
	}

	@Override
	public List<SellerVO> searchAccess() {
		return sellerDao.selectAccess();
	}
	
	@Override
	public int updateAcc(int sno) {
		return sellerDao.update(sno);
	}
	//------------------------------------------여기까지

} // end class SellerServiceImpl
