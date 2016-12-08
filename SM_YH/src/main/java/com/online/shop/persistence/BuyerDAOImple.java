package com.online.shop.persistence;


import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shop.domain.BuyerVO;
import com.online.shop.domain.CartandBuy;
import com.online.shop.pageutil.PageCriteria;
import com.online.shop.pageutil.SearchPageCriteria;


@Repository
public class BuyerDAOImple implements BuyerDAO {

	private static final String NAMESPACE = "com.online.shop.ShopMapper";
	private static final String NAMESPACEM = "com.online.shop.MypageMapper";
	
	private static Logger logger = LoggerFactory.getLogger(BuyerDAOImple.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BuyerVO> select() {
		List<BuyerVO> list = sqlSession.selectList(NAMESPACE + ".buyerSelectAll");
		logger.info("select() 호출:" + list.size());
		
		return list;
	}
	
	
	@Override
	public int getNumOfRecords() {
		return sqlSession.selectOne(NAMESPACE + ".totalCount");
	}
	
	@Override
	public List<BuyerVO> select(PageCriteria cri) {
		return sqlSession.selectList(NAMESPACE + ".listPage", cri);
	}
	
	@Override
	public List<BuyerVO> listSearch(SearchPageCriteria crit) {
		List<BuyerVO> list = sqlSession.selectList(NAMESPACE + ".listSearch", crit);
		logger.info("SearchCriteria list: " + list.size());
			return list;
	} 
	
	@Override
	public int listSearchCount(SearchPageCriteria crit) {		
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", crit);
	}
	
	// 구매자 마이페이지
	@Override
	public List<CartandBuy> selectBybuymain2(String b_id) {
		logger.info("b_id: " + b_id);
		return sqlSession.selectList(NAMESPACEM + ".selectBybuymain2", b_id);
	}
	
	// 구매 완료
	@Override
	public List<CartandBuy> selectBybuyComplete(String b_id) {
		return sqlSession.selectList(NAMESPACEM + ".selectBybuyComplete", b_id);
	}

	// 구매 내역 조회
	@Override
	public List<CartandBuy> selectBybuymain(String b_id) {
		return sqlSession.selectList(NAMESPACEM + ".selectBybuymain", b_id);
	}

	// 구매 완료 내역 조회
	@Override
	public List<CartandBuy> selectBybuyCompleteMain(String b_id) {
		return sqlSession.selectList(NAMESPACEM + ".selectBybuyCompleteMain", b_id);
	}
	
	// 전체 구매 내역 조회
	@Override
	public List<CartandBuy> selectByOrderMain(String b_id) {
		return sqlSession.selectList(NAMESPACEM + ".selectByOrderMain", b_id);
	}
	
	// 전체 완료 내역 조회
	@Override
	public List<CartandBuy> selectByBuyCompleteMain2(String b_id) {
		return sqlSession.selectList(NAMESPACEM + ".selectByBuyCompleteMain2", b_id);
	}
	
}
