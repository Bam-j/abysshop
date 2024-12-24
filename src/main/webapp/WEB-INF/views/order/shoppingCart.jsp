<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    info="사용자가 장바구니에 담은 상품 목록들을 보여주는 페이지입니다."
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>장바구니</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/common.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/header.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/footer.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/table.css">
  <link rel="stylesheet" href="../../../resources/static/styles/order/shoppingCart.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="../common/header.jsp" %>
<nav>
  <form action="/" method="get">
    <button type="button" class="btn btn-outline-dark">
      <i class="bi bi-arrow-left"></i>메인으로
    </button>
  </form>
</nav>
<main>
  <section>
    <table>
      <thead>
      <tr>
        <th>상품명</th>
        <th>금액/포인트</th>
        <th>삭제</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${shoppingCart}" var="item">
        <tr>
          <td>${item.name}</td>
          <td>${item.price}</td>
          <td><a href="#">삭제</a></td>
        </tr>
      </c:forEach>
      </tbody>
      <tfoot>
      <tr>
        <td>합계 금액</td>
        <td>
          <%-- 나중에 value를 총합 계산하는 로직으로 변경하기 --%>
          <c:set var="totalPrice" value="${item.price}"></c:set>
          ${totalPrice}
        </td>
      </tr>
      </tfoot>
    </table>
    <form action="/payment/info" method="post">
      <button type="button" class="btn btn-primary">결제하기</button>
    </form>
  </section>
</main>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
