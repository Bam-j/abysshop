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
<html>
<head>
  <title>상품 목록</title>
</head>
<body>
<section>
  <h2>상품 목록</h2>
  <div class="item-list">
    <c:forEach items="${productList}" var="product">
      <div class="item">
        <img src="${product.imgUrl}" alt="${product.name} 이미지">
        <h3>${product.name}</h3>
        <p>${product.price}</p>
      </div>
    </c:forEach>
  </div>
</section>
</body>
</html>
