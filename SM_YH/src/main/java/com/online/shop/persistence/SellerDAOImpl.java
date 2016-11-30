package com.online.shop.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.ProductVO;

@Repository // 스프링에서 persistence Layer(DAO) 콤포넌트 빈 객체로 관리
public class SellerDAOImpl implements SellerDAO {

	private static final String NAMESPACE = 
			"com.online.shop.SellerMapper";
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SellerDAOImpl.class);
	
	// MyBatis 프레임워크를 사용하기 위해서 SqlSession 객체를 주입 받음
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ProductVO> selectAllProduct() {
		List<ProductVO> productList = sqlSession.selectList(NAMESPACE + ".selectAllProduct");
		
		logger.info("select() 호출: product size = " + productList.size());
		
		return productList;
	}

	@Override
	public List<ImageVO> selectAllImage() {
		List<ImageVO> imageList = sqlSession.selectList(NAMESPACE + ".selectAllImage");
		
		logger.info("select() 호출: image size = " + imageList.size());
		
		return imageList;
	}

} // end class SellerDAOImpl
