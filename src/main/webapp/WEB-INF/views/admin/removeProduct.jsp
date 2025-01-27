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
<!DOCTYPE html>
<html>
<head>
  <title>상품 삭제</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
<section>
  <table>
    <thead>
    <tr>
      <td>상품명</td>
      <td>가격</td>
      <td>삭제</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productAndPointItemList}" var="item">
      <td>${item.name}</td>
      <td>${item.price}</td>
      <td>
        <form action="/admin/product/remove" method="post">
          <input type="hidden" name="productId" value="${item.productId}">
          <button type="submit" class="btn btn-warning">품목 삭제</button>
        </form>
      </td>
    </c:forEach>
    </tbody>
  </table>
</section>
</body>
</html>
