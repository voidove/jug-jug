<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
  <a href="TestForwardServlet">Click me(response)</a>
  <table>
     <c:forEach var="item" items="${testList}">
         <tr>
           <td>${item}</td> 
         </tr>
     </c:forEach>
</table>
</body>
</html>