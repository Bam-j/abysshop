<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:56
  To change this template use File | Settings | File Templates.
  info="관리자 페이지에서 사용되는 메뉴 바 입니다."
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>관리자 페이지 메뉴바</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/nav.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<nav class="nav">
  <a class="nav-link active" aria-current="page" href="?menu=goods-order-management">주문 관리</a>
  <a class="nav-link" href="?menu=point-recharge-management">포인트 지급 요청</a>
  <a class="nav-link" href="?menu=add-productEntity">상품 추가</a>
  <a class="nav-link" href="?menu=remove-productEntity">상품 삭제</a>
</nav>

<script src="../resources/static/js/common/navEvent.js"></script>
</body>
</html>
