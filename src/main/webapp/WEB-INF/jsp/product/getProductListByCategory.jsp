<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getProductListByCategory</title>
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 	
</head>
<body>
	<h1>상품 리스트</h1>
	<div> 해당 카테고리 상품 수 : ${productCount}</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>categoryNo</th>
				<th>productCommonName</th>
				<th>productCommonPrice</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${list}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/product/getProduct?productCommonNo=${p.productCommonNo}">${p.categoryNo}</a></td>
					<td>${p.productCommonName}</td>
					<td>${p.productCommonPrice }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 페이징 작업 -->
	<ul class="pager">
		<!-- 이전버튼 -->
		<c:if test="${currentPage > 1}">
			<li class="previous"><a href="${pageContext.request.contextPath}/product/getProductListByCategory?categoryNo=${categoryNo}&currentPage=${currentPage-1}">이전</a></li>
		</c:if>
		<!-- 다음버튼 -->
		<c:if test="${currentPage < lastPage}">
			<li class="next"><a href="${pageContext.request.contextPath}/product/getProductListByCategory?categoryNo=${categoryNo}&currentPage=${currentPage+1}">다음</a></li>
		</c:if>
	</ul>
	
</body>
</html>