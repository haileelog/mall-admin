<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "EUC-KR">
<title>RemoveMember</title>
</head>
<body>
	<h1>회원탈퇴</h1>
	<h5>${alert}</h5>
	<form action="${pageContext.request.contextPath}/member/removeMember" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="memberNo" value="${loginMember.memberNo}"></td>
			</tr>	
			<tr>
				<td><input type="hidden" name="memberId" value="${loginMember.memberId}"></td>
			</tr>
			<tr>			
				<td>비밀번호</td>
				<td><input type="password" name="memberPw"></td>
			</tr>
		</table>
		<button type="submit">탈퇴하기</button>
	</form>
</body>
</html>