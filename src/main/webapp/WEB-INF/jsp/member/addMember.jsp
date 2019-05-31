<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "EUC-KR">
<title>AddMember</title>
</head>
<body>
	<h1>회원가입</h1>	
	<form action="${pageContext.request.contextPath}/member/addMember" method="post">
		<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="memberId" id="memberId" value="${memberId}"><br></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="memberPw" id="memberPw"></td>
		</tr>
		<tr>
			<td>이   름</td>
			<td><input type="text" name="memberName" id="memberName"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="memberPhone" id="memberPhone"></td>
		</tr>
		<tr>
			<td>주   소</td>
			<td><input type="text" name="memberAddress" id="memberAddress"></td>
		</tr>
		<tr>
			<td>성   별</td>
			<td>
				<input type="radio" name="memberGender" id="memberGender" value="M">남성<br>
				<input type="radio" name="memberGender" id="memberGender" value="F">여성<br>
			</td>
		</tr>	
		<tr>
			<td>이메일</td>
			<td><input type="text" name="memberEmail" id="memberEmail"></td>
		</tr>
		</table>
		<!-- 회원가입은 무조건 consumer만 되도록 하자 -->
		<input type="hidden" name="memberLevel" id="memberLevel" value="consumer">
		<button type="submit">회원가입</button>
	</form>	
</body>
</html>