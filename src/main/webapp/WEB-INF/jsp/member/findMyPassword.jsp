<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FindMyPassword</title>
</head>
<body>
	<h1>비밀번호 찾기</h1>
	<h5>이메일을 입력하시면 비밀번호를 전송해드립니다</h5>
		<form action="${pageContext.request.contextPath}/member/findMyPassword" method="post">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="memberName" id="memberName"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="memberId" id="memberId"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="memberEmail" id="memberEmail"></td>
				</tr>
			</table>
			<button type="submit">비밀번호 찾기</button>
		</form>
</body>
</html>