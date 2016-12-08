package com.online.shop.persistence;

import java.util.List;


import com.online.shop.domain.BuyerVO;
import com.online.shop.domain.CartandBuy;
import com.online.shop.pageutil.PageCriteria;
import com.online.shop.pageutil.SearchPageCriteria;


public interface BuyerDAO {

	public abstract List<BuyerVO> select();
	
	public abstract int getNumOfRecords();
	
	public abstract List<BuyerVO> select(PageCriteria cri) ;
	
	public abstract List<BuyerVO> listSearch(SearchPageCriteria crit);
	
	public int listSearchCount(SearchPageCriteria crit);
	
	// 구매자 마이페이지
	public abstract List<CartandBuy> selectBybuymain2(String b_id);
	
	public abstract List<CartandBuy> selectBybuyComplete(String b_id);
	
	public abstract List<CartandBuy> selectBybuymain(String b_id);
	
	public abstract List<CartandBuy> selectBybuyCompleteMain(String b_id);
	
	
	// --------------------
	
	
}
