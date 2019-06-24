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
	<input type="hidden" name = "idx" value = "${idx_value}"/>   
   
    <label>이름</label>
    <input type="text" placeholder="이름입력" name="name" value="${name_value}" />
    
    <label>주소</label>
    <input type="text" placeholder="좋아하는 색상" name="address" value="${address_value}" />
    
    <label>생일</label>
    <select name = "birthday_month">
		<option value="1" ${select_month_1}>1월</option>
		<option value="2" ${select_month_2}>2월</option>
		<option value="3" ${select_month_3}>3월</option>
		<option value="4" ${select_month_4}>4월</option>
		<option value="5" ${select_month_5}>5월</option>
		<option value="6" ${select_month_6}>6월</option>
		<option value="7" ${select_month_7}>7월</option>
		<option value="8" ${select_month_8}>8월</option>
		<option value="9" ${select_month_9}>9월</option>
		<option value="10" ${select_month_10}>10월</option>
		<option value="11" ${select_month_11}>11월</option>
		<option value="12" ${select_month_12}>12월</option>
		</select>
		<select name="birthday_day">
		<option value="1" ${select_day_1}>1일</option>
		<option value="2" ${select_day_2}>2일</option>
		<option value="3" ${select_day_3}>3일</option>
		<option value="4" ${select_day_4}>4일</option>
		<option value="5" ${select_day_5}>5일</option>
		<option value="6" ${select_day_6}>6일</option>
		<option value="7" ${select_day_7}>7일</option>
		<option value="8" ${select_day_8}>8일</option>
		<option value="9" ${select_day_9}>9일</option>
		<option value="10" ${select_day_10}>10일</option>
		<option value="11" ${select_day_11}>11일</option>
		<option value="12" ${select_day_12}>12일</option>
		<option value="13" ${select_day_13}>13일</option>
		<option value="14" ${select_day_14}>14일</option>
		<option value="15" ${select_day_15}>15일</option>
		<option value="16" ${select_day_16}>16일</option>
		<option value="17" ${select_day_17}>17일</option>
		<option value="18" ${select_day_18}>18일</option>
		<option value="19" ${select_day_19}>19일</option>
		<option value="20" ${select_day_20}>20일</option>
		<option value="21" ${select_day_21}>21일</option>
		<option value="22" ${select_day_22}>22일</option>
		<option value="23" ${select_day_23}>23일</option>
		<option value="24" ${select_day_24}>24일</option>
		<option value="25" ${select_day_25}>25일</option>
		<option value="26" ${select_day_26}>26일</option>
		<option value="27" ${select_day_27}>27일</option>
		<option value="28" ${select_day_28}>28일</option>
		<option value="29" ${select_day_29}>29일</option>
		<option value="30" ${select_day_30}>30일</option>
		<option value="31" ${select_day_31}>31일</option>
	
	</select>
	
    <label>좋아하는 색상</label>
    <input type="text" placeholder="좋아하는 색상" name="favoriteColor" value="${color_value}" />
    
    <input type="submit" value="입력 완료" />
  </form>
</body>

</html>