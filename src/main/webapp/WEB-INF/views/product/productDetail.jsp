<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    info="상품, 포인트의 상세 페이지입니다."
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <title>상품 상세 페이지</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.3/dist/cerulean/bootstrap.min.css"
        rel="stylesheet">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/common.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/header.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/footer.css">
  <link rel="stylesheet" href="../../../resources/static/styles/product/productDetail.css">
  <%--<link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">--%>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<nav>
  <form action="/" method="get">
    <button type="submit" class="btn btn-outline-dark">
      <i class="bi bi-arrow-left"></i>메인으로
    </button>
  </form>
</nav>
<main>
  <section>
    <img src="" alt="상품 이미지">
    <ul>
      <li><h2><strong>${product.productName}</strong></h2></li>
      <li><h3>${product.price}</h3></li>
      <li>${product.description}</li>
      <li>
        <form action="/cart/item/add" method="post">
          <input type="hidden" name="cartId" value="${user.cartId}">
          <input type="hidden" name="productId" value="${product.productId}">
          <button type="submit" class="btn btn-primary">
            <i class="bi bi-cart"></i> 장바구니 담기
          </button>
        </form>
      </li>
    </ul>
  </section>
</main>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
