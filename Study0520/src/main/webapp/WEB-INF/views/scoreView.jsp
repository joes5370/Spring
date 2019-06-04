<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form{margin: 0 auto; padding: 10px; background : #eee;}
	label {display: inline-block; width: 200px; text-align: center;}
	input {display: inline-block; width: 300px;}
	form span{display: block; padding: 10px;}
	input[type = "submit"] {display: inline-block; margin: 5px 0px 0px 140px;}
</style>

<link rel="stylesheet" type = "text/css" href="score.css"/>

</head>
<body>
	
	<form action = "/spring/score" method="get"> 
		<span><label>이름 </label><input type = "text" placeholder = "이름" name = "name"/> </span>
		<span><label>중간성적</label><input type = "number" name = "middle_score"/> </span>
		<span><label>기말성적</label><input type = "number" name = "final_score"/> </span>
		<input type ="submit" value = "데이터 전송" id = "btn"/>
	</form>
	<span id = "span">${query_result}</span>

</body>

<script src = "http://code.jquery.com/jquery-latest.min.js">
</script>

</html>