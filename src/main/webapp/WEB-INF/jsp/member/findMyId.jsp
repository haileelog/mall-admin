<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FindMyId</title>
</head>
<body>
	<h1>아이디 찾기</h1>
		<form action="${pageContext.request.contextPath}/member/findMyId" method="post">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="memberName" id="memberName"><span id="helper"></span></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="memberEmail" id="memberEmail"></td>
				</tr>
			</table>
			<button type="submit">아이디 찾기</button>
		</form>
</body>
</html>