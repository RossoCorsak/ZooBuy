<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="domain.Goods" %>
<%@ page import="domain.Users" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<jsp:include page="/header.jsp"></jsp:include>

<html>
<head>
    <title>My Trade</title>
</head>
<body>
<h1>我的订单</h1>
<a href="ShowGoodsServlet">返回首页</a>





<div class="row" style="width: 1210px; margin: 0 auto;">


    <c:forEach items="${tradeOfUsers}" var="trade">
    <div class="col-md-2" style="height: 250px">
        <p>
            <a style='color: green'>${trade.gname }</a>
        </p>
        <p>
            <font color="#FF0000">&yen;${trade.price }</font>
        </p>
        <p>
            订单号：${trade.tid }
        </p>
        <p>
            收货信息：
        </p>
        <p>
            ${trade.realname }
        </p>
        <p>
                ${trade.phone }
        </p>
        <p>
                ${trade.address }
        </p>

    </div>

    </c:forEach>

</body>
</html>
