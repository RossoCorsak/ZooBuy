<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<div class="col-md-3" style="padding-top:20px">
  <ol class="list-inline">
    <c:if test="${empty user}">
      <li><a href="login.jsp">登录</a></li>
      <li><a href="register.jsp">注册</a></li>
    </c:if>
    <c:if test="${!empty user}">
      <li>${user.username}</li>
      <li><a href="login.jsp">退出</a></li>

    </c:if>

    <li><a href="ShowCartServlet">购物车</a></li>
    <li><a href="ShowTradingRecordServlet">我的订单</a></li>
  </ol>
</div>

