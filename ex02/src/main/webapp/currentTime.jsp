<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오전 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import = "java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE>
<html lang="ko">
<head>
    <title>스크립트릿 실습</title>
</head>
<body>
<h1>
현재 날짜 출력 실습
<%--    html 코드 내에 자바 코드를 넣어주는걸 스크립트코드라 한다 --%>
</h1>

<%
    Date date = new Date();

    int sum = 0;
    for(int i=0; i<10; i++){
        sum +=1;
    }
    Date d2 = null;
%>

현재 날짜 = <%= date %> <br>
1~10의 합: <%= sum %> <br>
<%=d2%>
</body>
</html>
