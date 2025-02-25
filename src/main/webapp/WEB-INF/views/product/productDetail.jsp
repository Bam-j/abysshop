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
        href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.3/dist/cosmo/bootstrap.min.css">
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
    <button type="submit" class="btn btn-outline-dark btn-sm">
      <i class="bi bi-arrow-left"></i>목록으로
    </button>
  </form>
</nav>

<main>
  <section>
    <img src="/upload/${product.originalFileName}" id="product-detail-image" alt="상품 이미지">
    <ul>
      <li><h2><strong>${product.productName}</strong></h2></li>
      <li><h3><strong>${product.price} 포인트</strong></h3></li>
      <li id="product-description">${product.description}</li>
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
