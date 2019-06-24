<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>rune</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/sign_in.css" />
</head>

<body>
  <div class="wrap">
    <div class="login_content">
      <div class="logo_sec">
        <h3>로그인 해주세요</h3>
      </div>
      <form class="login_sec" action="do_sign_in">
        <input type="text" placeholder="id" class="login_input" required="required" name="id"/>
        <input type="password" placeholder="password" class="login_input" required="required" name="passwd" />
        <input type="submit" class="login_btn" value="가입완료" />
      </form>
    </div>
  </div>
</body>

</html>