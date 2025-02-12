<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:01
  To change this template use File | Settings | File Templates.
  info="상품 리스트를 보여주는 뷰 입니다. 리스트의 항목을 클릭하면 해당 물품의 상세 페이지로 이동합니다."
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
  <title>상품 목록</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../../resources/static/styles/product/productList.css">
</head>
<body>
<section>
  <h2>상품 목록</h2>
  <%-- TODO: 한 페이지에 아이템이 8개씩(4개씩 2줄) 노출되도록 페이지네이션 --%>
  <div class="item-list">
    <c:forEach items="${productList}" var="product">
      <div class="item" data-item-id="${product.productId}">
        <a href="/product/detail/${product.productId}">
          <img src="/upload/${product.originalFileName}" class="card-img-top"
               alt="${product.productName}">
          <div class="card-body">
            <h5 class="card-title">${product.productName}</h5>
            <p class="card-text">${product.price}</p>
          </div>
        </a>
      </div>
    </c:forEach>
  </div>
</section>
</body>
</html>
