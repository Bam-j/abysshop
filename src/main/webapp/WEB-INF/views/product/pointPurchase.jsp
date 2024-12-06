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
<%-- 상품 이미지, 상품명, 가격 --%>
<h3>포인트 상품 목록</h3>

<table class="itemList">
  <tbody>
  <c:forEach items="${pointProductList}" var="pointProduct">
    <tr>
      <td><img src="${pointProduct.imgUrl}" alt="${pointProduct.imgUrl}"></td>
      <td>${pointProduct.name}</td>
      <td>${pointProduct.price}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
