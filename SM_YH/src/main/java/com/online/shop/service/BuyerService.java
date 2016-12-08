package com.online.shop.service;

import java.util.List;

import com.online.shop.domain.BuyerVO;
import com.online.shop.domain.CartandBuy;
import com.online.shop.pageutil.PageCriteria;
import com.online.shop.pageutil.SearchPageCriteria;

public interface BuyerService {

	public abstract List<BuyerVO> read();

	public abstract List<BuyerVO> read(PageCriteria cri);

	public abstract int getNumOfRecords();
	
	public abstract List<BuyerVO> listSearchCriteria(SearchPageCriteria cri);
	
	public abstract int listSearchCount(SearchPageCriteria cri);
	
	// 구매자 마이 페이지
	public abstract List<CartandBuy> read(String b_id);
	
	// 구매 완료
	public abstract List<CartandBuy> complete(String b_id);
	
	// 구매 내역
	public abstract List<CartandBuy> readmain(String b_id);
	
	// 구매 완료 내역
	public abstract List<CartandBuy> readCompleteMain(String b_id);
	
	// 전체 구매 내역
	public abstract List<CartandBuy> readordermain(String b_id);
	
	// 전체 구매 완료 내역
	public abstract List<CartandBuy> readCompleteMain2(String b_id);
	
	
}
