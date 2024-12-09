<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:01
  To change this template use File | Settings | File Templates.
  info="결제에 사용되는 포인트 상품 리스트를 보여주는 뷰 입니다."
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>포인트 상품 목록</title>
</head>
<body>
<section>
  <h2>포인트 상품 목록</h2>
  <div class="item-list">
    <c:forEach items="${pointList}" var="pointItem">
      <div class="item">
        <img src="${pointItem.imgUrl}" alt="${pointItem.name} 이미지">
        <h3>${pointItem.name}</h3>
        <p>${pointItem.price}</p>
      </div>
    </c:forEach>
  </div>
</section>
</body>
</html>
