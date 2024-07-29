<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 입력 파라미터 추력</h1>
<%--getParameter로 request.jsp에서 넘어온 데이터중 해당 키의 value값을 가져온다--%>
<%
    String userid = request.getParameter("userid");
    String Password = request.getParameter("Password");
    String strAge = request.getParameter("age");
    int age = strAge != null ? Integer.parseInt(strAge) : -1;
%>
<%--http://localhost:8080/loginInfo.jsp?userid=김소진&Password=1234 주소로 받아온 값이 출력된다--%>
아이디값: <%=userid%><br>
비밀번호: <%=Password%> <br>
<%--나이: <%= age%>--%>

</body>
</html>
