<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootstrap E-commerce Templates</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
<!-- bootstrap -->
<link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>"
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
<script
	src="<c:url value='/resources/themes/js/jquery.scrolltotop.js' />"></script>


<!--[if lt IE 9]>			
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
</head>
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
						<li><a href="admin_bootstrap.jsp">Login</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="wrapper" class="container">
		<section class="navbar main-menu">
			<div class="navbar-inner main-menu">
				<a href="index.html" class="logo pull-left"><img
					src="<c:url value='/resources/themes/images//logo.png" class="site_logo'/>"
					alt=""></a>
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
			
			<h3 class="titlem">
				<span><a href="admin_mypage"><strong>관리자</strong> 페이지</a></span>
			</h3> 
			
		</section>
		<section class="main-content">
			<div class="row">
				<div class="span5 sp">
					<h3 class="title">
						<span class="text"><strong>판매</strong> 관리</span>
					</h3>
					<form action="#" method="post">
						<input type="hidden" name="next" value="/">
						<fieldset>
							<div class="control-group">
								<label class="control-label"><a href="buyr" id="test">전체
										주문 요청 내역</a></label>

							</div>
							<div class="control-group">
								<label class="control-label"><a href="buyf">전체 판매 내역</a></label>
							</div>
							<div class="control-group">
								<label class="control-label"><a href="#">전체 판매
										통계</a></label>
							</div>
							</fieldset>
					<h3 class="title">
						<span class="text"><strong>회원</strong> 관리</span>
					</h3>
						<fieldset>
							<div class="control-group">
								<label class="control-label"><a
									href="seller_accept_list">판매자 회원 목록</a></label>
							</div>
							<div class="control-group">
								<label class="control-label"><a
									href="seller_accept_product_list">판매물 등록 승인</a></label>
							</div>
							<div class="control-group">
								<label class="control-label"><a href="listview">구매자
										회원 목록</a></label>
							</div>
							<hr>
						</fieldset>
					</form>
				</div>
				<div id="maindi" class="span7">
					<h3 class="title">
						<span class="text"><strong>구매자 </strong> 회원 목록</span>
					</h3>
					
					
						<fieldset>
							<div class="control-group">
								<select name="searchType" class="searchSelect">
			<option value="n" <c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
			<option value="i" <c:out value="${cri.searchType eq 'i'?'selected':''}"/>>회원 ID</option>
			<option value="n" <c:out value="${cri.searchType eq 'n'?'selected':''}"/>>회원 명</option>
			<option value="in" <c:out value="${cri.searchType eq 'in'?'selected':''}"/>>회원 ID or 회원 명</option>>
		</select>
				
		<input type="text" name="keyword" id="keywordInput" class="searchi" value='${cri.keyword }' />
		<button id='searchBtn'>Search</button>	

		<table id="table" class="buyerT">
			<tr>
				<th>회원번호</th>
				<th>회원명</th>
				<th>회원ID</th>
				<th>가입일</th>
				<th>상세정보</th>
			</tr>
			<!-- 모든 회원에 대한 정보 보기 -->
			<c:forEach var="buyer" items="${buyerList}">
				<c:if test="${buyer.b_gender eq 1 }">
					<c:set var="user_gender" value="남자"></c:set>
				</c:if>
				<c:if test="${buyer.b_gender eq 0 }">
					<c:set var="user_gender" value="여자"></c:set>
				</c:if>
				<tr>
					<td class="bno">${buyer.b_no}</td>
					<td class="bname">${buyer.b_name}</td>
					<td class="bid">${buyer.b_id}</td>
					<td class="breg"><fmt:formatDate value="${buyer.b_reg }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><button class="detail">상세 정보 보기</button></td>
					<td class="phone" style="display: none;">${buyer.b_phone }</td>
					<td class="email" style="display: none;">${buyer.b_email }</td>
					<td class="birth" style="display: none;">${buyer.b_birth }</td>
					<td class="gender" style="display: none;">${user_gender }</td>
					<td class="addr" style="display: none;">${buyer.b_addr }</td>
					<td class="mile" style="display: none;">${buyer.b_mile }</td>
				</tr>
			</c:forEach>
		</table>

		<ul class="pageLinks" >
			<li>-</li>
			<c:if test="${pageMaker.hasPrev }">
				<li id="page"><a href="${pageMaker.startPageNum - 1 }">&laquo;이전</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPageNum }"
				end="${pageMaker.endPageNum }" var="num">
				<li id="page"><a href="${num }">${num }</a></li>
			</c:forEach>

			<c:if test="${pageMaker.hasNext }">
				<li id="page"><a href="${pageMaker.endPageNum + 1 }">다음&raquo;</a></li>
			</c:if>
			<li>-</li>
		</ul>
		
		<%-- 현재 페이지, 페이지 당 보여줄 게시글 개수를 서버로 보내주기 위해서,
사용자에게는 보이지 않지만, 서버로 보낼 정보를 양식 데이터로 저장하는 form --%>
		<form id="pageForm">
			
			<input type="hidden" name="page" value="${pageMaker.criteria.page }" /> 
			<input type="hidden" name="perPage" value="${pageMaker.criteria.perPage }" />
		</form>
								

							</div>
								<!-- a 태그 클릭시 보여지는 상세한 회원 정보  div밖으로 빼는거 고려-->
	<div id="detail">

		<h4>회원 상세 정보</h4>

		<label for="bno">회원번호</label> <input type="text" name="d_bno"	id="d_bno" class="detail_i"  readonly><br />
		<label for="bname">이름</label> <input type="text" name="d_bname" id="d_bname" class="detail_i" readonly><br /> 
		<label for="bid">아이디</label> <input type="text" name="d_bid" id="d_bid" class="detail_i" readonly><br /> 
		<label for="bphone">연락처</label> <input type="text" name="d_bphone" id="d_bphone" class="detail_i" readonly><br />
	    <label for="breg">가입일</label> <input type="text" name="d_breg" id="d_breg"	class="detail_i" readonly><br />
	    <label for="bemail">이메일</label> <input	type="text" name="d_bemail" id="d_bemail" class="detail_i" readonly><br />
	    <label for="bbirth">생일</label> <input type="text" name="d_bbirth" id="d_bbrith" class="detail_i" readonly><br /> 
	    <label for="bgender">성별</label> 	<input type="text" name="d_bgender" id="d_bgender" class="detail_i" readonly><br />
		<label for="baddr">주소</label> <input type="text" name="d_baddr"	id="d_baddr"  class="detail_i" readonly><br />
		<label for="bmile">마일리지</label> <input type="text" name="d_bmile" id="d_bmile" class="detail_i" readonly><br />
		<button id="close">닫기</button>
	</div>

						

						</fieldset>
					<hr>
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
						<img src="<c:url value='../resources/themes/images/logo.png' />"
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
			<span>Copyright 2013 bootstrappage template All right
				reserved.</span>
		</section>
	</div>
	<script src="<c:url value='/resources/themes/js/common.js' />"></script>

	<script>
		$(document).ready(function() {
			$('#checkout').click(function(e) {
				document.location.href = "checkout.html";
			});

		});
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		$(document).ready(
				function() {
					
					
					// a 태그 클릭시 -> 수정원츄 원래의 a태그 방식으로!
					$('#table').on('click', 'button', function() {
						$('#detail').show();

						var data = $(this).parent().parent();

						var bno = $(data).children('.bno').text();
						var name = $(data).children('.bname').text();
						var id = $(data).children('.bid').text();
						var date = $(data).children('.breg').text();
						var phone = $(data).children('.phone').text();
						var email = $(data).children('.email').text();
						var brith = $(data).children('.birth').text();
						var gender = $(data).children('.gender').text();
						var addr = $(data).children('.addr').text();
						var mile = $(data).children('.mile').text();

						$('#d_bno').val(bno);
						$('#d_bname').val(name);
						$('#d_bid').val(id);
						$('#d_breg').val(date);
						$('#d_bphone').val(phone);
						$('#d_bemail').val(email);
						$('#d_bbrith').val(brith);
						$('#d_bgender').val(gender);
						$('#d_baddr').val(addr);
						$('#d_bmile').val(mile);

					});

					// 닫기 버튼시 상세보기 창이 닫힌다.
					$('#close').click(function() {
						$('#detail').hide();
					});

					var frm = $('#pageForm');

					// 클래스 pageLinks 안의 li 태그 안의 a 태그를 찾아서 click 이벤트를 커스터마이징
					$('.pageLinks li a').click(function() {
						event.preventDefault(); // 기본 이벤트 처리 방식을 방지(막음)
						// pageForm 안에 있는 name="page"인 요소를 찾아서
						// 이동할 페이지 번호를 세팅
						var targetPage = $(this).attr('href');
						console.log('targetPage=' + targetPage);
						frm.find('[name="page"]').val(targetPage);
						// 페이징 화면으로 보내기 위한 action 정보
						frm.attr('action', 'listview');
						// 페이징 화면을 처리하는 Controller의 method(요청 처리 방식)
						frm.attr('method', 'get');
						// 폼 양식을 서버로 전송
						frm.submit();
					});

					$('#searchBtn').on( "click", function(event) { 
						
						self.location = "searchlist" 
							+ "?page=1"
							+ "&perPage=5"
							+ "&searchType="
							+ $("select option:selected").val()
							+ "&keyword=" + encodeURI($('#keywordInput').val());
				 	
					});
					 
				});
		
		
	</script>


</body>
</html>