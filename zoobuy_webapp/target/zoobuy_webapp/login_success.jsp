<%@ page import="domain.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login Success</title>
</head>
<body>
<h1>Welcome <%=((Users)session.getAttribute("user")).getUsername()%></h1>
<a href="mainshop.jsp">进入商城</a>
</body>
</html>
