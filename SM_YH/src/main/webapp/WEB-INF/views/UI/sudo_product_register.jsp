<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootstrap E-commerce Templates</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">

	<style>
		#opTable1 {
	   		 width: 80px;
		}
		#opTable2 {
	   		 width: 120px;
		}
		#opTable3{
	   		 width: 40px;
		}
	</style>
<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
<!-- bootstrap -->
<link
	href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">
	
<link
	href="<c:url value='/resources/bootstrap/css/bootstrap-responsive.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/resources/themes/css/bootstrappage.css' />"
	rel="stylesheet" />

<!-- global styles -->
<link href="<c:url value='/resources/themes/css/flexslider.css' />"
	rel="stylesheet" />
<link href="<c:url value='/resources/themes/css/main.css' />"
	rel="stylesheet" />

<!-- scripts -->
<script src="<c:url value='/resources/themes/js/jquery-1.7.2.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/resources/themes/js/superfish.js' />"></script>
<script src="<c:url value='/resources/themes/js/jquery.scrolltotop.js' />"></script>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>


<script>

$(function() {
	$("select[name=p_cate1]").change(function() {
		var temp = $("select[name=p_cate2]");
		var p_cate1 = $(this).val();
		temp.children().remove();
		temp.append('<option value="none">--------</option>');

		if (p_cate1 == 'homedeco') {
			temp.append('<option value="furni">가구</option>');
			temp.append('<option value="cera">도자기</option>');
			temp.append('<option value="lamp">조명</option>');
		}

		if (p_cate1 == 'candlediffu') {
			temp.append('<option value="candle">캔들</option>');
			temp.append('<option value="diffu">디퓨저</option>');
			temp.append('<option value="aroma">아로마오일</option>');
		}

		if (p_cate1 == 'artfancy') {
			temp.append('<option value="pic">사진</option>');
			temp.append('<option value="fancy">문구</option>');
			temp.append('<option value="paper">페이퍼</option>');
		}

		if (p_cate1 == 'jewelry') {
			temp.append('<option value="ear">귀걸이</option>');
			temp.append('<option value="neck">목걸이</option>');
			temp.append('<option value="ring">반지</option>');
		}

	});
});

//옵션 양식 추가 및 삭제
$(function() {
	$('#addOption').click(function() {
		$('#optionTable > tbody:last').append('<tr><td><input type="text" name="o_title" placeholder="옵션제목" /></td>'
							+ '<td><input type="text" name="o_cont" placeholder="옵션내용" /></td>'
							+ '<td><input type="number" name="o_stock" placeholder="옵션재고" value="0" /></td></tr>');
	});

	$('#delOption').click(function() {
		$('#optionTable > tbody:last > tr:last').remove();
	});

});

// 이미지 양식 추가 및 삭제
$(function() {
	$('#addImage').click(function() {
		$('#imageTable > tbody:last').append('<tr><td><input type="text" class="i_set" id="i_img" name="i_img" placeholder="각 이미지의 URL을 넣어주세요..."/><br/>' 
							+ '<textarea rows="5" cols="65" class="i_set" name="i_cont" placeholder="이미지에 대한 설명을 넣어주세요..."> </textarea></td></tr>');
	});
	
	$('#delImage').click(function() {
		$('#imageTable > tbody:last > tr:last').remove();
	});
});

// 이미지 관련 처리
var feedback = function(res) {
	if (res.success === true) {
		document.querySelector('.status').classList.add('bg-success');
		document.querySelector('.status').innerHTML = res.data.link;
	}
};

new Imgur({
	clientid : '7ff152b0e154c31', /* http://imgur.com/ 에서 아이디를 만들어 발급했음  */
	callback : feedback
// TODO: 사진을 업로드하면 사진은 imgur서버상에 존재... 그러나 웹 사이트 계정에선 확인 불가...
});
</script>

</head><!-- -------------------------------------------------------------- -->


<body>
	<div id="top-bar" class="container">
		<div class="row">
			<div class="span4">
				<form method="POST" class="search_form">
					<input type="text" class="input-block-level search-query"
						Placeholder="eg. T-sirt">
				</form>
			</div>
			<div class="span8">
				<div class="account pull-right">
					<ul class="user-menu">
						<li><a href="#">My Account</a></li>
						<li><a href="cart.html">Your Cart</a></li>
						<li><a href="checkout.html">Checkout</a></li>
						<li><a href="register.html">Login</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="wrapper" class="container">
		<section class="navbar main-menu">
			<div class="navbar-inner main-menu">
				<a href="index.html" class="logo pull-left">
				<img src="<c:url value='/resources/themes/images/logo.png' />"
					class="site_logo" alt=""></a>
				<nav id="menu" class="pull-right">
					<ul>
						<li><a href="./products.html">Woman</a>
							<ul>
								<li><a href="./products.html">Lacinia nibh</a></li>
								<li><a href="./products.html">Eget molestie</a></li>
								<li><a href="./products.html">Varius purus</a></li>
							</ul></li>
						<li><a href="./products.html">Man</a></li>
						<li><a href="./products.html">Sport</a>
							<ul>
								<li><a href="./products.html">Gifts and Tech</a></li>
								<li><a href="./products.html">Ties and Hats</a></li>
								<li><a href="./products.html">Cold Weather</a></li>
							</ul></li>
						<li><a href="./products.html">Hangbag</a></li>
						<li><a href="./products.html">Best Seller</a></li>
						<li><a href="./products.html">Top Seller</a></li>
					</ul>
				</nav>
			</div>
		</section>
		<section class="header_text sub">
			<img class="pageBanner"
				src="<c:url value='/resources/themes/images/pageBanner.png' />"
				alt="New products">
			<h4>
				<span>For Seller</span>
			</h4>
		</section>
		<section class="main-content">
			<div class="row">
				<div class="span12">
					<div class="accordion" id="accordion2">
					
						<!-- -------------------------------------------------------------- -->
						<!-- -------------------------------------------------------------- -->
						<!-- -------------------------------------------------------------- -->
					
					
					
					
					<div class="accordion-group">
					
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion2" href="#collapseOne">Register Product</a>
							</div>
							<div id="collapseOne" class="accordion-body in collapse">
								<div class="accordion-inner">
									<div class="row-fluid">
									<h4 class="title"><span class="text"><strong>Register</strong> Form</span></h4>
									
									<!-- <form action="b_register_result" method="post" id="fileForm1" role="form">** submit -->
									<form action="pRegister" method="post">		<!-- TODO : ****** -->
									
										<!-- ######################################## -->
										<!-- 왼쪽 -->
										<div class="span6">
											
											
											
											<!-- hidden type으로 입력될 값들... 판매자 이름은 로그인 정보와 합친 후 수정  -->
											<!-- 판매자 이름 -->
											<input type="hidden" name="s_id" value="seller1" />
											<!-- 관심상품 -->
											<input type="hidden" name="p_favo" value="0" />
											<!-- 판매량 -->
											<input type="hidden" name="p_sale_cnt" value="0" />
											
											<!-- -------------------------------------------------------------- -->
											
										 
											<div class="control-group">
												<label>카테고리</label> 
												<div class="controls">
													<select name="p_cate1" class="input-xlarge">
														<option value="none">--------</option>
														<option value="homedeco">홈/데코</option>
														<option value="candlediffu">캔들/디퓨저</option>
														<option value="artfancy">아트/팬시</option>
														<option value="jewelry">쥬얼리</option>
													</select> <br/>
													<select name="p_cate2" class="input-xlarge">
														<option value="none">--------</option>
													</select>
													<!-- <input class="input-xlarge" type="text" name="b_name" id="txt"
														required placeholder="홍길동" /> -->
												</div>
											</div><!-- ### 완료 ###-->
											 
											<!-- -------------------------------------------------------------- -->
											
											<div class="control-group">
												<label for="p_name">작품명</label> 
												<div class="controls">
													<input class="input-xlarge" type="text" name="p_name" required />
												</div>
											</div><!-- ### 완료 ###-->
											<!-- -------------------------------------------------------------- -->
											
											 <div class="control-group">
											 	<label for="p_price">작품가격</label> 
											 	<div class="controls">
											 		<input class="input-xlarge" type="number" name="p_price" required />
												</div>
											 </div><!-- ### 완료 ###-->
											 
											<!-- -------------------------------------------------------------- -->
											
											 <div class="control-group">
												<label for="p_stock">재고량</label> <!-- TODO -->
												<div class="controls">
													<input class="input-xlarge" type="number" name="p_stock" required />
												</div> <!-- TODO :  -->
											 </div><!-- ### 완료 ###-->

											
											<!-- -------------------------------------------------------------- -->
											
											<div class="control-group">
												<label for="b_phone">할인율</label>
												<div class="controls">
													<input class="input-xlarge" type="number" name="p_dis_rate" value="0" />
												</div>
											</div>
											 
											<!-- -------------------------------------------------------------- -->
											<!-- <div class="control-group">
												<label for="b_gender">성별</label> 
												<label class="radio-inline">
													<input type="radio" name="b_gender" value="1" checked>남자
												</label> 
												<label class="radio-inline">
													<input type="radio" name="b_gender" value="2">여자
												</label>
											</div> ### 완료 ###
											 <br> -->
											
											
											
										</div>










										<!-- ######################################## -->
										<!-- 오른쪽 -->
										<div class="span6">
										
											<div class="control-group">
												<label>옵션</label>
												<div class="controls">
													
													<table id="optionTable">
														<tr>
															<td><input id="opTable1" type="text" name="o_title" placeholder="옵션제목" /></td>
															<td><input id="opTable2" type="text" name="o_cont" placeholder="옵션내용" /></td>
															<td><input id="opTable3" type="number" name="o_stock" placeholder="옵션재고" value="0" /></td>
														</tr>
														<tbody></tbody>
													</table>
													<button id="addOption" type="button">옵션추가</button>
													<button id="delOption" type="button">옵션삭제</button>
												</div>
											</div>										 
											
											 
											 <hr>
											 <div class="control-group">
											 	<label for="b_email">이미지</label>
											 	<div class="col-md">
													<div class="dropzone"></div>
												</div>
												<div class="controls" id="b_email">
													<!-- <label>대표 이미지</label><br/> -->
													<input class="input-xlarge" type="text" class="i_set" id="p_img" name="p_img" placeholder="메인 이미지 "/><br/>
													<table id="imageTable"  >
														<tr>
															<td>
																<input class="input-xlarge" type="text" class="i_set" id="i_img" name="i_img" placeholder="각 이미지의 URL을 넣어주세요..."/><br/>
																<textarea class="input-xlarge" rows="5" cols="65" class="i_set" name="i_cont" placeholder="이미지에 대한 설명을 넣어주세요..."> </textarea>
															</td>
														</tr>
														<tbody></tbody>
														
													</table>
													
												</div>
											 </div>
											 
											 
											<br>
										</div>
													
									</form><!--  End -->

								
									</div>
									<hr>
											<div class="actions">
												<input tabindex="9" class="btn btn-inverse large" type="submit" value="등록">
												<input tabindex="9" class="btn btn-inverse large" type="reset" value="취소">
											</div>	<br/>
								</div>
								
							</div>
									
							
						</div><!-- End  -->
			
						
						
						
						<!-- -------------------------------------------------------------- -->
						<!-- -------------------------------------------------------------- -->
						<!-- -------------------------------------------------------------- -->
									
					</div><!-- #### -->
				</div>
			</div>
		</section>
		<section id="footer-bar">
			<div class="row">
				<div class="span3">
					<h4>Navigation</h4>
					<ul class="nav">
						<li><a href="./index.html">Homepage</a></li>
						<li><a href="./about.html">About Us</a></li>
						<li><a href="./contact.html">Contac Us</a></li>
						<li><a href="./cart.html">Your Cart</a></li>
						<li><a href="./register.html">Login</a></li>
					</ul>
				</div>
				<div class="span4">
					<h4>My Account</h4>
					<ul class="nav">
						<li><a href="#">My Account</a></li>
						<li><a href="#">Order History</a></li>
						<li><a href="#">Wish List</a></li>
						<li><a href="#">Newsletter</a></li>
					</ul>
				</div>
				<div class="span5">
					<p class="logo">
						<img src="<c:url value='/resources/themes/images/logo.png' />"
							class="site_logo" alt="">
					</p>
					<p>Lorem Ipsum is simply dummy text of the printing and
						typesetting industry. the Lorem Ipsum has been the industry's
						standard dummy text ever since the you.</p>
					<br /> <span class="social_icons"> <a class="facebook"
						href="#">Facebook</a> <a class="twitter" href="#">Twitter</a> <a
						class="skype" href="#">Skype</a> <a class="vimeo" href="#">Vimeo</a>
					</span>
				</div>
			</div>
		</section>
		<section id="copyright">
			<span>December 2016 Web Project All right.</span>
		</section>
	</div>
	<!-- <script src="/shop01/resources/themes/js/common.js"/></script> -->
</body>
</html>