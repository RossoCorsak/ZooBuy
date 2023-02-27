<%@ page import="domain.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
  <title>Register Success</title>
</head>
<body>
<h1>注册成功！请牢记你的9位UID：<%=((Users)session.getAttribute("user")).getUid()%></h1>
<a href="login.jsp">前往登录</a>
</body>
</html>
