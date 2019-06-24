<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
	<style>
	
	</style>
	
  <link href="${pageContext.request.contextPath}/resources/input.css"
	rel="stylesheet" />
</head>

<body>
  <a href="">목록으로</a>
  <form action="update_data" method="get">
	<input type="hidden" name = "idx" value = "${idx}"/>   
   
    
    <label>ID</label>
    <input type="text" placeholder="ID입력" name="ID" value="${ID}" />
    
    <label>passwd</label>
    <input type="text" placeholder="비\
    
    asswd" value="${passwd}" />
    
    
    
    <input type="submit" value="입력 완료" />
  </form>
	
	
</body>
</html>