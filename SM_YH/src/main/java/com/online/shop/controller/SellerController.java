package com.online.shop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.online.shop.domain.ImageVO;
import com.online.shop.domain.OptionVO;
import com.online.shop.domain.ProductVO;
import com.online.shop.domain.SellerVO;
import com.online.shop.service.ProductService;
import com.online.shop.service.SellerService;

@Controller // 스프링 프레임워크에 Controller bean 객체로 등록
@RequestMapping(value="/seller")
public class SellerController {

	private static final Logger logger = 
			LoggerFactory.getLogger(SellerController.class);
	
	@Autowired 
	ProductService productService;
	
	@Autowired
	SellerService sellerService;
	
	@RequestMapping(value="/pList", method=RequestMethod.GET)
	public void sellerHome(Model model, String s_id) {
		// 전체 상품 리스트
		List<ProductVO> productList = sellerService.readAllProduct();
		logger.info("productList size: " + productList.size());
		// 전체 상품 리스트를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("productList", productList);

		// 판매자 아이디에 의해 판매자 정보 받아오기
		s_id = "seller1";
		SellerVO sellerInfo = sellerService.readSellerInfo(s_id);
		// 판매자 정보를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("sellerInfo", sellerInfo);
		
	} // end sellerHome() -> 판매자 홈에서 상품 리스트를 보여주는 역할
	
	/*----------------------------------------------------------------------------*/
	
	/* 
	@RequestMapping(value="pDetail", method=RequestMethod.GET)
	public void productDetail(int p_no, String s_id, String p_name, Model model) {
		// 상품 번호에 의한 각 상품의 전체 정보 받아오기
		ProductVO pVo = sellerService.readItemByPno(p_no);
		// 전체 정보를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("productVO", pVo);
		
		// 옵션 정보를 받아오기
		List<OptionVO> optionList = sellerService.readOpByPno(p_no);
		// 받아온 옵션 정보를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("optionList", optionList);
		
		// 이미지 정보를 받아오기
		List<ImageVO> imageList = sellerService.readImgByPno(p_no);
		// 받아온 이미지 정보를  Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("imageList", imageList);
		
		// 판매자 정보 받아오기
		s_id = "seller1";
		SellerVO sVo = sellerService.readSellerInfo(s_id);
		// 판매자 정보를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("sVo", sVo);
		
		List<ProductVO> list = productService.selectCate2(pVo.getP_cate2());
		model.addAttribute("relativeList", list);
		
		
	} // end productDetail() -> 판매자 홈에서 상품 번호를 참조해 상품 상세 페이지로 넘겨주는 역할 
	*/ 
	
	@RequestMapping(value="logoPop", method=RequestMethod.GET)
	public void logoPopGet() {
		
	}
	
	@RequestMapping(value="logoPop", method=RequestMethod.POST)
	public void logoPopPost(SellerVO sVo) {
		
		// 서비스 객체를 사용하여 로고 이미지 update
		int LUpResult = sellerService.updateLogo(sVo);
		logger.info("결과: " + LUpResult);
	}
	
	@RequestMapping(value="infoPop", method=RequestMethod.GET)
	public void infoPopGet() {
		
	}
	
	@RequestMapping(value="infoPop", method=RequestMethod.POST)
	public void infoPopPost(SellerVO sVo) {
		
		// 서비스 객체를 사용하여 판매자 정보 update
		int IUpResult = sellerService.updateInfo(sVo);
		logger.info("결과: " + IUpResult);
	}

	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainHome(Model model) {
		logger.info("main 컨트롤러 실행");
		// 전체 상품 리스트
		List<ProductVO> productList = sellerService.readAllProduct();
		
		int length = productList.size();
		int numOfPage =  length / 4;
		if (length % 4 > 0) {
			numOfPage++; // 나머지가 있으면 올림 	 
			// 뷰페이저로 한 페이지에 4개씩 출력 !
			// ex) (9/4 = 2.X )=> 3페이지 필요
		}
		int remainder = length % 4;
		
		// 전체 상품 리스트를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("productList", productList);
		model.addAttribute("numOfPage", numOfPage);
		model.addAttribute("remainder", remainder);
		logger.info("length : " + length);
		logger.info("numOfPage : "+numOfPage);
		logger.info("remainder : "+remainder);
		/*logger.info(productList.get(0).getP_name());*/
		
		
		return "UI/sudo_index";
		
	} // end sellerHome() -> 판매자 홈에서 상품 리스트를 보여주는 역할
	
	
	/*----------------------------------------------------------------------------*/
	
	// TODO : ProductController로 이동
	
	@RequestMapping(value="pDetail", method=RequestMethod.GET)
	public String product_Detail(int p_no, String s_id, String p_name, Model model) {
		
		ProductVO pVo = sellerService.readItemByPno(p_no);	// 상품 번호에 의한 각 상품의 전체 정보 받아오기
		List<OptionVO> optionList = sellerService.readOpByPno(p_no);	// 옵션 정보를 받아오기
		List<ImageVO> imageList = sellerService.readImgByPno(p_no);	// 이미지 정보를 받아오기
		List<ProductVO> productList = sellerService.readAllProduct();	// 전체 상품 리스트
		List<ProductVO> cateCheck = productService.selectCate2(pVo.getP_cate2());	// 카테고리가 연관된 작품 리스트
		
		// 판매자 정보 받아오기
		s_id = "seller1";
		SellerVO sVo = sellerService.readSellerInfo(s_id);
		
		int length = productList.size();
		int numOfPage =  length / 4;
		if (length % 4 > 0) {
			numOfPage++; // 나머지가 있으면 올림 	 
		}
		int remainder = length % 4;
		
		model.addAttribute("productVO", pVo);	// 전체 정보를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("optionList", optionList);	// 받아온 옵션 정보를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("imageList", imageList);	// 받아온 이미지 정보를  Model 객체에 넣어서 View(jsp)에 전달
		
		// 전체 상품 리스트를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("productList", productList);
		model.addAttribute("numOfPage", numOfPage);
		model.addAttribute("remainder", remainder);
		model.addAttribute("relativeList", cateCheck);	// 카테고리 검색해서 연관상품 보여주기
		model.addAttribute("sVo", sVo);

	
			
		
		return "UI/sudo_product_detail";
		
	} // end productDetail() -> 판매자 홈에서 상품 번호를 참조해 상품 상세 페이지로 넘겨주는 역할 
	
	
	/*----------------------------------------------------------------------------*/
	
	
	
} // end class SellerController
