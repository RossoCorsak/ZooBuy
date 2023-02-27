<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>注册ZooBuy用户</h1>
<form action="RegisterServlet" method="post">
    <table border="0">
        <tr><td>用户名:</td><td><input type="text" name="username"></td></tr>
        <tr><td>密码:</td><td><input type="password" name="password"></td></tr>
        <tr><td>手机号:</td><td><input type="text" name="phone"></td></tr>
        <tr><td colspan="2"><input type="submit" value="Register"></td></tr>
    </table>
</form>
