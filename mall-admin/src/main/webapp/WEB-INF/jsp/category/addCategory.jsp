<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addCategory</title>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script>
$(document).ready(function(){
	$('#addBtn').click(function(){
		console.log('addBtn click...');
		$('#addCategoryForm').submit();
	});	
});
</script>
</head>
<body>
	<h1>카테고리 추가</h1>
	<form id="addCategoryForm" action="${pageContext.request.contextPath}/category/addCategory" method="post">
		<div>
			이름 : 
		</div>
		<div>
			<input type="text" name="categoryName">
		</div>
		<div>
			<button id="addBtn" type="button">추가</button>
		</div>
	</form>
</body>
</html>