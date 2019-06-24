<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
  <meta charset="utf-8" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/list.css" />
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/list.js"></script>
</head>

<body>
  <div id="wrap">
    <div class="top_button_section">
      <a href="join" class="top_button">회원가입</a>
      <a href="login" class="top_button">로그인</a>
      <a href="my_account" class="top_button">내카드보기</a>
    </div>
    <ul class="player_list">
     ${list}
    </ul>
    <div class="select_section">
      <form action="do_battle" method="GET">
        <input type="text" name="select1" />
        <input type="text" name="select2" />
        <input type="submit" value="대전시작" />
      </form>
    </div>
  </div>
</body>

</html>