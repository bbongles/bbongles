package com.online.shop.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.OptionVO;
import com.online.shop.domain.ProductVO;
import com.online.shop.domain.SellerVO;
import com.online.shop.pageutil.PageCriteria;
import com.online.shop.pageutil.SearchPageCriteria;

@Repository // 스프링에서 persistence Layer(DAO) 콤포넌트 빈 객체로 관리
public class SellerDAOImpl implements SellerDAO {

	private static final String NAMESPACE = 
			"com.online.shop.SellerMapper";
	private static final String NAMESPACEM = "com.online.shop.ShopMapper";
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SellerDAOImpl.class);
	
	// MyBatis 프레임워크를 사용하기 위해서 SqlSession 객체를 주입 받음
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ProductVO> selectAllProduct() {
		List<ProductVO> productList = sqlSession.selectList(NAMESPACE + ".selectAllProduct");
		
		logger.info("selectAllProduct() 호출: product size = " + productList.size());
		
		return productList;
	}

	@Override
	public ProductVO selectItemByPno(int p_no) {
		logger.info("selectItemByPno() 호출: p_no = " + p_no);
		
		ProductVO pVo = sqlSession.selectOne(NAMESPACE + ".selectItemByPno", p_no);
		
		return pVo;
	}

	@Override
	public List<OptionVO> selectOpByPno(int p_no) {
		logger.info("selectOpByPno() 호출: p_no = " + p_no);
		
		List<OptionVO> optionList = sqlSession.selectList(NAMESPACE + ".selectOpByPno", p_no);
		
		return optionList;
	}

	@Override
	public List<ImageVO> selectImgByPno(int p_no) {
		logger.info("selectImgByPno() 호출: p_no = " + p_no);
		
		List<ImageVO> imageList = sqlSession.selectList(NAMESPACE + ".selectImgByPno", p_no);
		
		return imageList;
	}

	@Override
	public int updateLogo(SellerVO sVo) {
		logger.info("updateLogo() 호출: s_id = " + sVo.getS_id());
		
		return sqlSession.update(NAMESPACE + ".updateLogo", sVo);
	}

	@Override
	public SellerVO selectSellerInfo(String s_id) {
		logger.info("selectSellerInfo() 호출: s_id = " + s_id); 
		
		SellerVO sellerInfo = sqlSession.selectOne(NAMESPACE + ".selectSellerInfo", s_id);
		
		return sellerInfo;
	}

	@Override
	public int updateInfo(SellerVO sVo) {
		logger.info("updateInfo() 호출: s_id = " + sVo.getS_id());
		
		return sqlSession.update(NAMESPACE + ".updateInfo", sVo);
	}
	
	// 관리자 페이지 관련
	@Override
	public List<SellerVO> select() {
		List<SellerVO> list =  sqlSession.selectList(NAMESPACEM + ".sellerSelectAll");
		logger.info("select() 호출: " + list.size());
				
		return list;
	}
	
	@Override
	public int getNumOfRecords() {
		return sqlSession.selectOne(NAMESPACEM + ".sellerTotalCount") ;
	}
		
	@Override
	public List<SellerVO> select(PageCriteria cri) {
		return sqlSession.selectList(NAMESPACEM + ".sellerListPage", cri);
	}
	
	@Override
	public List<SellerVO> listSearch(SearchPageCriteria cri) { 
//		List<SellerVO> list = sqlSession.selectList(NAMESPACE + ".searchListSearch", cri);
//		System.out.println("list: "+ list.get(0).getS_id());
		return sqlSession.selectList(NAMESPACEM + ".searchListSearch", cri);
	}
	
	@Override
	public int listSearchCount(SearchPageCriteria cri) {
		return sqlSession.selectOne(NAMESPACEM + ".sellerListSearchCount", cri);
	}
	
	@Override
	public List<SellerVO> selectAccess() {
		return sqlSession.selectList(NAMESPACEM + ".selectAccess");
	}

	@Override
	public int update(int sno) {
		return sqlSession.update(NAMESPACEM + ".sellerAccept", sno);
	}
	//-------------------------------여기까지
	
} // end class SellerDAOImpl
