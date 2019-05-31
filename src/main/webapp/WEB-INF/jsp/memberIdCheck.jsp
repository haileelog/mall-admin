<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "EUC-KR">
<title>IdCheck</title>
</head>
<body>
	<h1>아이디 중복 검사</h1>
	<h5>${alert}</h5>
		<form action="${pageContext.request.contextPath}/memberIdCheck" method="post">		
			아이디    : <input type="text" name="memberId" id="memberId">
			<button type="submit">check</button>
		</form>
</body>
</html>