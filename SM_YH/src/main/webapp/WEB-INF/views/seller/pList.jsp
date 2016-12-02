<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
<style>
ul {
	list-style-type: none;
}
li {
	display: inline-block;
	text-align: center;
}
#totalBox {
	width: 1260px;
	margin: 0 auto;
}
.itemBox {
	width: 250px;
	height: 300px;
	margin: 20px;
}
img {
	width: 250px;
	height: 250px;
}


</style>
</head>
<body>

	<h1>상품 리스트</h1>
	
	<nav>
		<ul>
			<li><a href="pRegister">상품 등록</a></li>
		</ul>
	</nav>
	
	<hr/>
	
	<div id="totalBox">
		<ul>
		
			<c:forEach var="pVo" items="${productList }">
			<li>
				<a href="pDetail?p_no=${pVo.p_no }">
					<div class="itemBox">
						<img src="${pVo.p_img }" /><br/><br/>
						<a>${pVo.p_name }</a><br>
						<a>${pVo.p_price }</a>
					</div>
				</a>
			</li>
			</c:forEach>
			
		</ul>
	</div>
	
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	/* $(function(){
		var result = new Array();
		
		<c:forEach var="pVo" items="${productList}">
			var json = new Object();
			json.p_img = "${pVo.p_img}";
			json.p_name = "${pVo.p_name}";
			json.p_price = "${pVo.p_name}";
			result.push(json);
		</c:forEach>
		
		console.log("jsonPvo="+JSON.stringify(result));
	});
	
	list = '';
	list += '<tr><td><img src="'
		+ '${pVo.p_img }'
		+ '"</td>'
		+ '</tr>';
	
	$('#test_table').html(list); */
	
	
	
});

</script>
</html>