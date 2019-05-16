<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddProductCommon</title>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script>
$(document).ready(function(){
	$('#addProductCommonBtn').click(function(){
		console.log('addProductCommonBtn click...');
		$('#addProductCommonForm').submit();
	});	
});
</script>
</head>
<body>
	<h1>상품추가</h1>
	<form id="addProductCommonForm" action="${pageContext.request.contextPath}/product/addProductCommon?categoryNo=${categoryNo}" method="post">
		<table border="1">
			<tr>
				<td>categoryNo</td>
				<td>${categoryNo}</td>
			</tr>
			<tr>
				<td>productCommonName</td>
				<td><input type="text" name="productCommonName"></td>			
			</tr>
			<tr>
				<td>productCommonPrice</td>
				<td><input type="text" name="productCommonPrice"></td>			
			</tr>
			<tr>
				<td>productCommonDescription</td>
				<td><input type="text" name="productCommonDescription"></td>			
			</tr>
		</table>	
		<button id="addProductCommonBtn" type="button">ProductCommon 추가</button>
	</form>
</body>
</html>