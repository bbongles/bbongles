<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세페이지</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<style>
.preview {
	width: 300px;
	height: 230px;
}
.thumb {
	width: 90.7px;
	height: 81px;
	margin-right: 3px;
}
.normal {
	border:3px solid #000000;
}
.selected {
	border:3px solid #ff0000;
}
.detailInfo {
	float: left;
	margin: 20px;
}
</style>

</head>
<body>

	<h1>상품 상세페이지</h1>
	
	<hr/>
	
	<div class="detailInfo">
		<img id="bigOne" class="preview normal" src="http://i.imgur.com/wB73OvB.jpg" alt="preview" onclick="showPopup"><br/>
		<img id="smallOne" class="thumb normal" src="http://i.imgur.com/wB73OvB.jpg" onmouseover="preview(this)">
		<img id="smallTwo" class="thumb normal" src="http://i.imgur.com/IxpW9YU.jpg" onmouseover="preview(this)">
		<img id="smallThree" class="thumb normal" src="http://i.imgur.com/u1kXpzS.jpg" onmouseover="preview(this)">
	</div>
	<form>
	<div class="detailInfo">
		<input type="hidden" name="p_no" value="${productVO.p_no }" />    
    	<input type="hidden" name="s_id" value="${productVO.s_id }" />
    	<span>상품명 : </span>
    	${productVO.p_name }<br/><br/>
    	<span>상품가 : </span>
    	${productVO.p_price }<br/><br/>
    	<span>구매량 : </span>
    	<input type="number" name="buy_cnt" value="1" /><br/><br/>
    	<span>옵션 : </span>
    	<option>
    	
    	</option>
    </div>
    
    
    
	</form>
	
	
	<script>
    var lastImg = 'smallOne'; //Set initial thumbnail and preview
    document.getElementById('bigOne').src = document.getElementById(lastImg).src;
    document.getElementById(lastImg).className = "thumb selected";

    function preview(img) {
        document.getElementById(lastImg).className = "thumb normal";
        img.className = "thumb selected";
        document.getElementById('bigOne').src = img.src;
        lastImg = img.id
    }   
	</script>
	
</body>
</html>