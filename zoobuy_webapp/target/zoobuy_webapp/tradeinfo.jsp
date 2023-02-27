<%@ page import="domain.Users" %>
<%@ page import="domain.Goods" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Trade Info</title>
</head>
<body>
<h1>填写您的收货信息</h1>
<form action="addtrade" method="post">
    <table border="0">

        <tr><td>收件人:</td><td><input type="text" name="realname"></td></tr>
        <tr><td>电话:</td><td><input type="text" name="phone"></td></tr>
        <tr><td>地址:</td><td><input type="text" name="address"></td></tr>
        <tr><td colspan="2"><input type="submit" value="购买"></td></tr>
    </table>
</form>
