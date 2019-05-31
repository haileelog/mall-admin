<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "EUC-KR">
<title>INDEX</title>
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 
</head>
<body>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/index">Home</a>
	<h1>myPage</h1>
		<table border="1">
			<tr>
				<td>회원번호</td><td>${member.memberNo}</td>
			</tr>
			<tr>
				<td>아이디</td><td>${member.memberId}</td>
			</tr>
			<tr>
				<td>이름</td><td>${member.memberName}</td>
			</tr>
			<tr>
				<td>전화번호</td><td>${member.memberPhone}</td>
			</tr>
			<tr>
				<td>주소</td><td>${member.memberAddress}</td>
			</tr>
			<tr>
				<td>성별</td><td>${member.memberGender}</td>
			</tr>
			<tr>
				<td>등급</td><td>${member.memberLevel}</td>
			</tr>
			<tr>
				<td>이메일</td><td>${member.memberEmail}</td>
			</tr>
		</table>
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/member/modifyPersonalData?memberNo=${member.memberNo}">회원정보수정</a>
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/member/modifyPassword?memberNo=${member.memberNo}">비밀번호수정</a>
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/member/removeMember?memberNo=${member.memberNo}">회원탈퇴</a>
</body>
</html>