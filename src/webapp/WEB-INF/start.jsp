<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p> start jsp</p>
<br/>

<ul>
    <c:forEach var="user" items="${userList}">
        <li>${user.name}</li>
    </c:forEach>
</ul>

<br/>
<p>-----------------------------------------------------</p>

<p>-----------------------------------------------------</p>
<br/>

<ul>
    <c:forEach var="student" items="${userListModify}">
        <li>${student.name}</li>
    </c:forEach>
</ul>

</body>
</html>
