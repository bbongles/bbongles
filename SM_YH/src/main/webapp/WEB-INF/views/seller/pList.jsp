<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
<style>
ul {
	list-style-type: none;
}
table, td {
	border: 1px solid gray;
	border-collapse: collapse;
}
td {
	width: 200px;
}
img {
	width: 200px;
	height: 200px;
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
	
	<table>
		<tr>
		<c:forEach var="iVo" items="${imageList }">
		<td><img src="${iVo.i_img }" /></td>
		</c:forEach>
		</tr>
		<tr>
		<c:forEach var="iVo" items="${imageList }">
		<td><a>${iVo.p_name }</a></td>
		</c:forEach>
		</tr>
		
	</table>
	
</body>
</html>