<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo 목록 보기</h1>
<div>
    <%-- EL을 사용해서 todoList 접근 --%>
        <c:forEach var="todo" items="${todoList}">
            <p>${todo}</p>
    </c:forEach>
</div>
<div>
  <a href="create">새 Todo</a>
</div>

</body>
</html>
