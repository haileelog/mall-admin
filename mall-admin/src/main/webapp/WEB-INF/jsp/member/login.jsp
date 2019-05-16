<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "EUC-KR">
<title>AdminLogin</title>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script>
$(document).ready(function(){
	$('#loginBtn').click(function(){
		console.log('loginBtn click...');
		$('#loginForm').submit();
	});	
});
</script>
</head>
<body>
	<h1>관리자 로그인</h1>
	<h5>${loginAlert}</h5>
		<form id="loginForm" action="${pageContext.request.contextPath}/member/login" method="post">		
				아이디    : <input type="text" name="memberId" id="memberId"><br>
				비밀번호 : <input type="password" name="memberPw" id="memberPw"><br>			
				Level : <input type="radio" name="memberLevel" id="memberLevel" value="employee">직원 
				<br>		
				<button id="loginBtn" type="button">로그인</button>
		</form>
</body>
</html>