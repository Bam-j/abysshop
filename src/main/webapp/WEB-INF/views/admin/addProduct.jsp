<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:09
  To change this template use File | Settings | File Templates.
  info="관리자 페이지의 상품 추가 뷰입니다."
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <title>상품 추가</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../../resources/static/styles/admin/addProduct.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<section>
  <form id="add-product-form" action="/admin/product/add" method="post"
        enctype="multipart/form-data">
    <label for="product-image">
      상품 이미지: <input type="file" id="product-image">
    </label>
    <input type="text" id="product-name" placeholder="상품명">
    <input type="text" id="product-price" placeholder="상품 가격">
    <textarea id="product-description" placeholder="상품 설명"></textarea>
    <div class="btn-group">
      <button type="button" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown"
              aria-expanded="false">
        일반 상품
      </button>
      <ul class="dropdown-menu">
        <li>
          <a class="dropdown-item" data-value="product" href="#">일반 상품</a>
        </li>
        <li>
          <a class="dropdown-item" data-value="point" href="#">포인트</a>
        </li>
      </ul>
    </div>
    <button type="submit" class="btn btn-primary">상품 등록</button>
  </form>
</section>
</body>
</html>
