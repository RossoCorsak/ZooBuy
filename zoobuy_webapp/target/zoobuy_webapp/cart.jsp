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
  <title>Cart</title>
</head>
<body>
<h1>Shopping Cart</h1>
<a href="ShowGoodsServlet">返回首页</a>





<div class="row" style="width: 1210px; margin: 0 auto;">


  <c:forEach items="${goodsInCart}" var="goods">
  <div class="col-md-2" style="height: 250px">

    <p>
      <a style='color: green'>${goods.gname }</a>
    </p>
    <p>
      <font color="#FF0000">商城价：&yen;${goods.price }</font>
    </p>
    <form action="buygoods"  id="buygoods" method="post">
      <div class="gid">
        <input type="hidden" value=${goods.gid} name="gid">
      </div>
      <div class="buy_btn">
        <input type="submit" class="buy_btn" value="购买">
      </div>
    </form>
  </div>

  </c:forEach>

</body>
</html>
