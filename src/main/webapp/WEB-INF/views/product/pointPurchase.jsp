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
<!DOCTYPE html>
<html>
<head>
  <title>포인트 상품 목록</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
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
