package com.online.shop;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired 
	ProductService productService;
	
	@Autowired
	SellerService sellerService;
	
	
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//return "home";
		// return "template_form";
		// return "UI/sudo_products";
		return "UI/sudo_index";
	}
*/
	
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	
	@RequestMapping(value="/", method=RequestMethod.GET)
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
		
	} // end mainHome
	
	/*----------------------------------------------------------------------------*/
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String product(Model model) {
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
		
		return "UI/sudo_products";
		
	} // end product
	
	/*----------------------------------------------------------------------------*/
	
	
	@RequestMapping(value="pDetail", method=RequestMethod.GET)
	public String product_Detail(int p_no, String s_id, String p_name, Model model) {
		
		ProductVO pVo = sellerService.readItemByPno(p_no);	// 상품 번호에 의한 각 상품의 전체 정보 받아오기
		List<OptionVO> optionList = sellerService.readOpByPno(p_no);	// 옵션 정보를 받아오기
		List<ImageVO> imageList = sellerService.readImgByPno(p_no);	// 이미지 정보를 받아오기
	//	List<ProductVO> productList = sellerService.readAllProduct();	// 전체 상품 리스트
		List<ProductVO> cateCheck = productService.selectCate2(pVo.getP_cate2());	// 카테고리가 연관된 작품 리스트
		
		// 판매자 정보 받아오기
		s_id = "seller1";
		SellerVO sVo = sellerService.readSellerInfo(s_id);
		
		int length = cateCheck.size();
		int numOfPage =  length / 4;
		if (length % 4 > 0) {
			numOfPage++; // 나머지가 있으면 올림 	 
		}
		int remainder = length % 4;
		
		model.addAttribute("productVO", pVo);	// 전체 정보를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("optionList", optionList);	// 받아온 옵션 정보를 Model 객체에 넣어서 View(jsp)에 전달
		model.addAttribute("imageList", imageList);	// 받아온 이미지 정보를  Model 객체에 넣어서 View(jsp)에 전달
		
		// 전체 상품 리스트를 Model 객체에 넣어서 View(jsp)에 전달
	//	model.addAttribute("productList", productList);
		model.addAttribute("numOfPage", numOfPage);
		model.addAttribute("remainder", remainder);
		model.addAttribute("relativeList", cateCheck);	// 카테고리 검색해서 연관상품 보여주기
		model.addAttribute("sVo", sVo);

		
		return "UI/sudo_product_detail";
		
	} // end productDetail() -> 판매자 홈에서 상품 번호를 참조해 상품 상세 페이지로 넘겨주는 역할 
	
	
	/*----------------------------------------------------------------------------*/
	
	
	
	
	
	
	
	
	
	
	
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	
	
	
	
	
	
} // end class HomeController
