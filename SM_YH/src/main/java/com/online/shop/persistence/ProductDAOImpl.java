package com.online.shop.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.shop.controller.ProductController;
import com.online.shop.domain.ImageVO;
import com.online.shop.domain.OptionVO;
import com.online.shop.domain.ProductVO;

@Repository // 스프링에서 persistence Layer(DAO) 콤포넌트 빈 객체로 관리
public class ProductDAOImpl implements ProductDAO {
	
	private static final String NAMESPACE = 
			"com.online.shop.ProductMapper";
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ProductController.class);

	// MyBatis 프레임워크를 사용하기 위해서 SqlSession 객체를 주입 받음
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertProduct(ProductVO pVo) {
		logger.info("insert(): p_name = " + pVo.getP_name());
		
		int result = sqlSession.insert(NAMESPACE + ".insertProduct", pVo);
		return result;
	} // end insertProduct()

	@Override
	public int selectProductNo(String s_id) {
		logger.info("select(): s_id = " + s_id);
		
		int pno  = sqlSession.selectOne(NAMESPACE + ".selectProductNo", s_id);
		
		return pno;
	} // end selectProductNo()
	
	@Override
	public int insertOption(OptionVO oVo) {
//		logger.info("insert(): o_title = " + oVo.getO_title());
		
		int result = sqlSession.insert(NAMESPACE + ".insertOption", oVo);
		return result;
	} // end insertOption()

	@Override
	public int insertImage(ImageVO iVo) {
		logger.info("insert(): i_img = " + iVo.getI_img());
		
		int result = sqlSession.insert(NAMESPACE + ".insertImage", iVo);
		
		return result;
	}

	@Override
	public ProductVO selectUpdateByPno(int p_no) {
		logger.info("selectUpdateByPno() 호출: p_no = " + p_no);
		
		ProductVO pVo = sqlSession.selectOne(NAMESPACE + ".selectUpdateByPno", p_no);
		
		return pVo;
	}

	@Override
	public List<OptionVO> selectOptionByPno(int p_no) {
		logger.info("selectOptionByPno() 호출: p_no = " + p_no);
		
		List<OptionVO> optionList = sqlSession.selectList(NAMESPACE + ".selectOptionByPno", p_no);
		
		logger.info("selectOptionByPno() 호출: size = " + optionList.size());
		
		return optionList;
	}
	
} // end class ProductDAOImpl
