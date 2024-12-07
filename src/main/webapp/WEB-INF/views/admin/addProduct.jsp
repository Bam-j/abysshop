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
<html>
<head>
  <title>상품 추가</title>
</head>
<body>
<section>
  <form action="/admin/product/add" method="post" enctype="multipart/form-data">
    <label for="product-image">상품 이미지: </label>
    <input type="file" id="product-image">
    <input type="text" id="product-name" placeholder="상품명">
    <input type="text" id="product-price" placeholder="상품 가격">
    <textarea id="product-description" placeholder="상품 설명"></textarea>
    <button>상품 등록</button>
  </form>
</section>
</body>
</html>
