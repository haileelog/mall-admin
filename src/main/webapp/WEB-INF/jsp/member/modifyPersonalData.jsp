<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "EUC-KR">
<title>modifyPersonalData</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form action="${pageContext.request.contextPath}/member/modifyPersonalData" method="post">
		<table border="1">
			<tr>
				<td>회원번호 : <input type="text" name="memberNo" value="${member.memberNo}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>아이디 : <input type="text" name="memberId" value="${member.memberId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이름 : <input type="text" name="memberName" value="${member.memberName}"></td>
			</tr>
			<tr>
				<td>전화번호 : <input type="text" name="memberPhone" value="${member.memberPhone}"></td>
			</tr>
			<tr>
				<td>주소 : <input type="text" name="memberAddress" value="${member.memberAddress}"></td>
			</tr>
			<tr>
			<td>성   별
				<c:if test='${member.memberGender == "M"}'>
						<input type="radio" name="memberGender" id="memberGender" value="M">남성
						<input type="radio" name="memberGender" id="memberGender" value="F">여성
				</c:if>
				<c:if test='${member.memberGender == "F"}'>
					<input type="radio" name="memberGender" id="memberGender" value="F">여성
					<input type="radio" name="memberGender" id="memberGender" value="M">남성
				</c:if>
				</td>
			</tr>
			<tr>
				<td>등급 : <input type="text" name="memberLevel" value="${member.memberLevel}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>이메일 : <input type="text" name="memberEmail" value="${member.memberEmail}"></td>
			</tr>
		</table>
		<br>
		비밀번호 입력
		<table border="1">
			<tr>
				<td>비밀번호 : <input type="password" name="memberPw" ></td>
			</tr>
		</table>
		<button type="submit">회원정보수정</button>
	</form>
</body>
</html>