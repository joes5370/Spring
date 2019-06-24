<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>

  </style>
  <link href="${pageContext.request.contextPath}/resources/input.css"
	rel="stylesheet" />
</head>

<body>
  <a href="">목록으로</a>
  <form action="update_data" method="get">
	<input type="hidden" name = "idx" value = "${idx}"/>   
   
    <label>이름</label>
    <input type="text" placeholder="이름입력" name="name" value="${name}" />
    
    <label>ID</label>
    <input type="text" placeholder="ID입력" name="ID" value="${ID}" />
    
    <label>Passwd</label>
    <input type="text" placeholder="비밀번호입력" name="passwd" value="${passwd}" />
    
    <label>주소</label>
    <input type="text" placeholder="좋아하는 색상" name="address" value="${address}" />
    
    <label>생일</label>
    <input type="text" placeholder="생일" name="birthday" value="${birthday}" />
    
    
    <label>좋아하는 색상</label>
    <input type="text" placeholder="좋아하는 색상" name="favoriteColor" value="${color_value}" />
    
    <input type="submit" value="입력 완료" />
  </form>
</body>

</html>