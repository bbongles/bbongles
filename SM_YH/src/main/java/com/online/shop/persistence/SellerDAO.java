package com.online.shop.persistence;

import java.util.List;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.OptionVO;
import com.online.shop.domain.ProductVO;
import com.online.shop.domain.SellerVO;
import com.online.shop.pageutil.PageCriteria;
import com.online.shop.pageutil.SearchPageCriteria;

public interface SellerDAO {

	public abstract List<ProductVO> selectAllProduct();

	public abstract ProductVO selectItemByPno(int p_no);

	public abstract List<OptionVO> selectOpByPno(int p_no);

	public abstract List<ImageVO> selectImgByPno(int p_no);

	public abstract int updateLogo(SellerVO sVo);

	public abstract SellerVO selectSellerInfo(String s_id);

	public abstract int updateInfo(SellerVO sVo);

	// 관리자 페이지 관련
	// 리스트를 받아오기 위한 select문
	public abstract List<SellerVO> select();

	// 전체 페이지수를 계산하기 위해서
	public abstract int getNumOfRecords();

	// paging 처리를 위한 select문
	public abstract List<SellerVO> select(PageCriteria cri);

	// 검색 기능을 위한 select문
	public abstract List<SellerVO> listSearch(SearchPageCriteria cri);

	// 검색 후 paging 처리를 위한 전체 페이지 계산
	public abstract int listSearchCount(SearchPageCriteria cri);

	// db에서 미승인된 판매자 회원 뽑아옴
	public abstract List<SellerVO> selectAccess();

	// 판매자 승인 처리
	public abstract int update(int sno);
	
	// ---------------------------여기까지

} // end interface SellerDAO
