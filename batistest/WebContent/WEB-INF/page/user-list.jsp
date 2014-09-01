<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>user list</title>
</head>
<body>
   <div>
    <c:forEach var="user" items="${userDTOList}">
        <div><span>${user.id}</span> <span>${user.userName}</span> <span>${user.password}</span></div>
    </c:forEach>
   </div>
</body>
</html>