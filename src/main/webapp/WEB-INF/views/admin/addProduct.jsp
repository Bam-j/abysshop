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
</head>
<body>
<section>
  <form id="add-product-form" action="/admin/product/add" method="post"
        enctype="multipart/form-data">
    <label for="product-image">
      상품 이미지: <input type="file" id="product-image" name="image" multiple>
    </label>
    <input type="text" id="product-name" name="productName" placeholder="상품명">
    <input type="text" id="product-price" name="price" placeholder="상품 가격">
    <textarea id="product-description" name="description" placeholder="상품 설명"></textarea>
    <button type="submit" class="btn btn-primary">상품 등록</button>
  </form>
</section>
</body>
</html>
