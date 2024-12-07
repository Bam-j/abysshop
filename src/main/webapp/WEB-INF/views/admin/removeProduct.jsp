<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:23
  To change this template use File | Settings | File Templates.
  info="관리자 페이지의 상품 삭제 뷰 입니다."
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>상품 삭제</title>
</head>
<body>
<table>
  <thead>
  <tr>
    <td>상품명</td>
    <td>가격</td>
    <td>삭제</td>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${products}" var="product">
    <td>${product.name}</td>
    <td>${product.price}</td>
    <td>
      <form action="/admin/product/delete" method="post">
        <button>삭제</button>
      </form>
    </td>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
