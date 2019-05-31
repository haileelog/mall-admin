<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "EUC-KR">
<title>modifyPassword</title>
</head>
<body>
	<h1>비밀번호 수정</h1>
	<form action="${pageContext.request.contextPath}/member/modifyPassword" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="memberNo" value="${loginMember.memberNo}"></td>
			</tr>
			<tr>
				<td>현재비밀번호 : <input type="password" name="currentPw"></td>
			</tr>
			<tr>
				<td>새로운 비밀번호 : <input type="password" name="memberPw"></td>
			</tr>
		</table>
		<button type="submit">비밀번호 수정하기</button>
	</form>
</body>
</html>