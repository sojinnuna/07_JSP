<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSTL 테스트</h1>
<hr>
<%--다른 문서를 삽입해야할때 include 사용법 2가지--%>
<%--<%include file ="navbar.jsp"--%>
<jsp:include page="navbar.jsp"/>

<table>
<%--    members 리스트를 하나씩 꺼내와서 member라는 이름으로 사용하겠다--%>
<%--    state라는 이름으로 루프 내부의 정보를 사용 가능--%>
    <c:forEach var="member" items="${members}" varStatus="state">
        <tr>
<%--            state 내에 있는 정보는 루프 정보로 우리가 만든 변수가 아님.--%>
            <td>${state.index}</td>
<%--    우리가 만든 Member 클래스로 접근하는 변수--%>
            <td>${member.name}</td>
            <td>${member.userid}</td>
        </tr>
    </c:forEach>
</table>
<br>

${today}<br>
<%--디폴트 (패턴 지정 안했을 때)--%>
<fmt:formatDate value="${today}" type="date"/><br>
<fmt:formatDate value="${today}" type="time"/><br>
<fmt:formatDate value="${today}" type="both"/><br>
<fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long"/><br>
<fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long"/><br>
<fmt:formatDate value="${today}" pattern="YYYY-MM-dd HH:mm:ss"/><br>
<fmt:formatDate value="${today}" pattern="YYYY-MM-dd a hh:mm:ss"/><br>

</body>
</html>
