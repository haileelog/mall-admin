<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "EUC-KR">
<title>Login</title>
</head>
<body>
	<h1>로그인</h1>
	<h5>${alert}</h5>
		<form action="${pageContext.request.contextPath}/member/login" method="post">		
				아이디    : <input type="text" name="memberId" id="memberId"><br>
				비밀번호 : <input type="password" name="memberPw" id="memberPw">			
				<button type="submit">로그인</button>
		</form>
</body>
</html>