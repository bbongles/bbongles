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
		border:3px solid gray;
	}
	.selected {
		border:3px solid gray;
	}
	.detailInfo {
		width: 400px;
		float: left;
		
	}
	#coveringBox {
		width: 1260px;
		margin: 0 auto;
		display: inline-block;
	}
	.locationSet {
		display: inline-block;
		margin-left: 400px;
	}
	#imageDetailInfo {
		width: 1260px;
		margin: 0 auto;
	}
	.detailImg {
		width: 800px;
		height: 600px
	}
	.detailCont {
		text-align: center;
	}
	#contentList {
		width: 1260px;
		margin: 0 auto;
		display: inline-block;
	}
	#detailMenu {
		width: 1260px;
		margin: 0 auto;
	}
	
	</style>

</head>
<body>

	<h1>상품 상세페이지</h1>
	
	<br/>
	
	<form id="frm">
	<div id="coveringBox">
		<div class="locationSet">
		
			<div class="detailInfo">		<!-- 이미지 -->
				<img id="big" class="preview normal" src="${productVO.p_img }" alt="preview" onclick="showPopup"><br/>
				
				<c:forEach var="imageList" items="${imageList }" end="2">
				
				<img id="small" class="thumb normal" src="${imageList.i_img }" onmouseover="preview(this)">
				</c:forEach>
			</div>
	
			<div class="detailInfo">
				<input type="hidden" name="p_no" value="${productVO.p_no }" />    
    			<input type="hidden" name="s_id" value="${productVO.s_id }" />
    			<span>상품명 : </span>
    			${productVO.p_name }<br/><br/>
    			<span>상품가 : </span>
    			${productVO.p_price } 원<br/><br/>
    			<span>구매량 : </span>
    			<input type="number" name="buy_cnt" value="1" /> 개<br/><br/>
    			<span>옵션 : </span>
    	
    			<!-- 해당 상품의 옵션 정보를 뿌려줘야 함 -->
    			<select>
    				<option value="none">--------</option>
    				<c:forEach var="optionList" items="${optionList}" end="0">
    				<option>${optionList.o_title }</option>
    				</c:forEach>
    			</select>
    			<select>
    				<option value="none">--------</option>
    				<c:forEach var="optionList" items="${optionList }">
    				<option>${optionList.o_cont }</option>
    				</c:forEach>
    			</select>
    		</div>
    	
    	</div>    
    </div><br/>
 
    <div id="imageDetailInfo">
    	<br/><hr/>
    	
    	<h3>이미지 정보</h3>
    	<c:forEach var="imageList" items="${imageList }">
    		<div style="text-align: center;" id="contentList">
    			<img src="${imageList.i_img }" class="detailImg" /><br/><br/>
    			<span class="detailCont">${imageList.i_cont }</span><br/><br/><br/>
    		</div>
    	</c:forEach>
    </div><br/>
    <hr/><br/>
    
    <div>관련 상품</div>
    <c:forEach var="relativeList" items="${relativeList}">
    	<div style="text-align: center">
    	<img src="${relativeList.p_img}" class="preview">
    	</div> 
    </c:forEach>
    
    
    <div id="detailMenu">
    	<input type="button" id="delProduct" value="상품삭제" />
    	<input type="button" id="gotoList" value="목록으로" />
    </div>
    <br/>

	</form>
	
	
	<script>
    var lastImg = 'small'; //Set initial thumbnail and preview
    document.getElementById('big').src = document.getElementById(lastImg).src;
    document.getElementById(lastImg).className = "thumb selected";

    function preview(img) {
        document.getElementById(lastImg).className = "thumb normal";
        img.className = "thumb selected";
        document.getElementById('big').src = img.src;
        lastImg = img.id
    }
    
    $('#delProduct').click(function() {
    	var result = confirm('정말 삭제하시겠습니까?');
    	if (result == true) {
    		$('#frm').attr('action', 'pDelete');
    		$('#frm').attr('method', 'post');
    		$('#frm').submit();
    	}
    });
    
    $('#gotoList').click(function() {
    	location = 'main';
    });
	</script>
	
</body>
</html>