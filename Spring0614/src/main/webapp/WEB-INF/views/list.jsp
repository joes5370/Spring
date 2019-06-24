<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataBase Sample</title>
<style>
</style>


<link href="${pageContext.request.contextPath}/resources/list.css"
	rel="stylesheet" />
</head>

<body>
	<a href="input">데이터 입력하기</a>
	<a href="sign_in">로그인하기</a>

	<table>
		<tr>
			<th>idx</th>
			<th>ID</th>
			<th>이름</th>
			<th>주소</th>
			<th>생일</th>
			<th>좋아하는 색</th>
			<th>수정</th>
			<th>삭제</th>
			
		</tr>
		${select_result}
	</table>
</body>

</html>