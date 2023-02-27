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
    <title>ZooBuy</title>
</head>
<body>
<h1>欢迎来到ZooBuy!</h1>







<div class="row" style="width: 1210px; margin: 0 auto;">


    <c:forEach items="${goodsList}" var="goods">
        <div class="col-md-2" style="height: 250px">

            <p>
                <a  style='color: green'>${goods.gname }</a>
            </p>
            <p>
                <font color="#FF0000">商城价：&yen;${goods.price }</font>
            </p>
            <form action="addcart"  id="addcart" method="post" target="frameName">
                <div class="gid">
                    <input type="hidden" value=${goods.gid} name="gid">
                </div>
                <div class="add_btn">
                    <input type="submit" class="add_btn" value="加入购物车">
                </div>
            </form>
            <!--只是为了不跳转-->
            <iframe src="" frameborder="0" name="frameName"></iframe>
        </div>

    </c:forEach>

</body>
</html>
