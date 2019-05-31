<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "EUC-KR">
<title>INDEX</title>
</head>
<body>
	<h1>INDEX</h1>	
		<h2>쇼핑몰 메인 페이지</h2>
		<div>
		<!-- 회원메뉴 -->
		</div>
			<ul>					
				<c:if test="${loginMember == null}">
					<h5>로그인이 되어있지 않습니다</h5>
					<li><a href="/member/login">로그인</a></li>
					<li><a href="/memberIdCheck">회원가입</a></li>
					<li><a href="/member/findMyId">아이디 찾기</a></li>
					<li><a href="/member/findMyPassword">비밀번호 찾기</a></li>
				</c:if>
				
				<c:if test="${loginMember != null }">
					<h5>로그인 상태</h5>
					<div>
					이름 : ${loginMember.memberName}<br>
					직급 : ${loginMember.memberLevel}
					</div>
					<br>
					<li><a href="/member/mypage?memberNo=${loginMember.memberNo}">마이페이지</a></li>
					<li><a href="/getMemberList">회원목록</a></li>
					<li><a href="/member/logout">로그아웃</a></li>	
				</c:if>
			</ul>
			
		<div>
		<!-- 쇼핑몰 메뉴 -->
		</div>
			<ul>
				<c:forEach var="category" items="${categoryList}">
					<li>
						<a href="${pageContext.request.contextPath}/product/getProductListByCategory?categoryNo=${category.categoryNo}&currentPage=1">${category.categoryName}</a>
					</li>			
				</c:forEach>
			</ul>
</body>
</html>