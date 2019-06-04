<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{width: 100%;}
td, th{border: 1px solid #eee; text-align:center; padding:5px 10px;}
th {background: #333; color: #fff;}
a{padding:5px 20px; background: #333; color: #fff;}
</style>
</head>
<body>
	<table>
	<tr>
	<th>idx</th>
	<th>이름</th>
	<th>중간고사</th>
	<th>기말고사</th>
	</tr>
	${list_result}
	</table>
	<a href = "/spring1/">입력화면으로 가기</a>
</body>
</html>