<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 정보 세션 저장</h1>
<%
    String id =request.getParameter("userid");
    //id가 null이거나 id가 빈 값이라면?
    if( id == null || id.equals("")) {
//        id가 null이거나 입력되지 않은 경우 loginForm.html오 다시 이동하도록 리디렉트 서설정
        response.sendRedirect("loginform.html");
    }else{
        String pw = request.getParameter("Password");
        session.setAttribute("userid", id);
        session.setAttribute("Password", pw);
        out.print("안녕하세요 "+id);
        out.print("<a href='loginInfo.jsp'>정보보기</a>");
    }
%>
</body>
</html>
