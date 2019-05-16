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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#searchBtn').click(function(){
			$('#searchForm').submit();
		});
	});
</script>
</head>
<body>
	<h1>ProductCommon 상품 리스트</h1>
	<div> 해당 카테고리 상품 수 : ${productCount}</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<td>categoryNo</td>
				<td>categoryName</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${categoryP.categoryNo}</td>
				<td>${categoryP.categoryName}</td>
			</tr>
		</tbody>
	</table>
	
	<div>
	<a href="${pageContext.request.contextPath}/product/addProductCommon?categoryNo=${categoryNo}">ProductCommon상품 추가</a>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>productCommonNo</th>
				<th>productCommonName</th>
				<th>productCommonPrice</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${categoryP.productCommons}">
				<tr>
					<td>${p.productCommonNo}</td>
					<td><a href="${pageContext.request.contextPath}/product/getProductListByProductCommonNo?productCommonNo=${p.productCommonNo}">${p.productCommonName}</a></td>
					<td>${p.productCommonPrice }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- 검색폼 -->
	<form action="/product/getProductListByCategory" method="get">
		<input type="hidden" value="${categoryNo}" name="categoryNo">	
		productName 검색어 : <input type="text" name="searchWord">
		<button type="button">검색</button>
	</form>
	
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