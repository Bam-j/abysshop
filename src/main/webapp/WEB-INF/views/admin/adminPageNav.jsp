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
</head>
<body>
<nav class="nav">
  <a class="nav-link active" aria-current="page" href="/admin/my-page?menu=order-management"
     onclick="changeURL('order-management')">주문 관리</a>
  <a class="nav-link" href="/admin/my-page?menu=point-recharge-management"
     onclick="changeURL('point-recharge-management')">포인트 지급 요청</a>
  <a class="nav-link" href="/admin/my-page?menu=add-product" onclick="changeURL('add-product')">상품
    추가</a>
  <a class="nav-link" href="/admin/my-page?menu=remove-product"
     onclick="changeURL('remove-product')">상품 삭제</a>
</nav>

<script type="text/javascript">
  function changeURL(menu) {
    if (menu === "order-management") {
      history.replaceState(null, null, "/admin/my-page?menu=order-management");
    } else if (menu === "point-recharge-management") {
      history.replaceState(null, null, "/admin/my-page?menu=point-recharge-management");
    } else if (menu === "add-product") {
      history.replaceState(null, null, "/admin/my-page?menu=user-info");
    } else if (menu === "remove-product") {
      history.replaceState(null, null, "/admin/my-page?menu=point-request");
    }
  }
</script>
</body>
</html>
