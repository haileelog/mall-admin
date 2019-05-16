<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddProduct</title>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script>
$(document).ready(function(){
	$('#addProductBtn').click(function(){
		console.log('addProductBtn click...');
		$('#addProductForm').submit();
	});	
});
</script>
</head>
<body>
	<h1>상품추가</h1>
	<form id="addProductForm" action="${pageContext.request.contextPath}/product/addProduct?productCommonNo=${productCommonNo}" method="post">
		<table border="1">
			<tr>
				<td>productCommonNo</td>
				<td>${productCommonNo}</td>			
			</tr>
			<tr>
				<td>productColor</td>
				<td><input type="text" name="productColor"></td>			
			</tr>
			<tr>
				<td>productSize</td>
				<td><input type="text" name="productSize"></td>			
			</tr>
			<tr>
				<td>productStock</td>
				<td><input type="text" name="productStock"></td>			
			</tr>			
		</table>	
		<button id="addProductBtn" type="button">Product 추가</button>
	</form>
</body>
</html>