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
  <%--<link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">--%>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<nav>
  <a href="/">
    <i class="bi bi-arrow-left"></i>메인으로
  </a>
</nav>
<main>
  <section>
    <table>
      <thead>
      <tr>
        <th>상품명</th>
        <th>포인트</th>
        <th>수량</th>
        <th>삭제</th>
      </tr>
      </thead>
      <tbody>
      <%--cartItemList--%>
      <c:forEach items="${cartItemList}" var="item">
        <tr>
          <td>${item.productName}</td>
          <td>${item.price}</td>
          <td>
          <%-- TODO: 증감 설정 버튼 CSS 입히기 --%>
          <%-- 페이지에 보여질 totalPoints(price), quantity는 스크립트에서 계산, order 저장시는 백엔드에서 계산 --%>
            <div style='display: flex;'>
              <input type='button'
                     onclick='count("plus")'
                     value='+' />
              <div id='result'>${item.quantity}</div>
              <input type='button'
                     onclick='count("minus")'
                     value='-' />
            </div>
          </td>
          <td>
          <%--cart--%>
            <form action="/cart/item/remove" method="post">
              <input type="hidden" name="cartId" value="${cart.cartId}">
              <input type="hidden" name="productId" value="${item.productId}">
              <input type="hidden" name="userId" value="${user.userId}">
              <button id="item-remove-button">X</button>
            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
      <tfoot>
      <tr>
        <td>주문 합계 포인트</td>
        <td>
          <%-- TODO: 스크립트로 총합 계산 후 합계 포인트 나타내기--%>
          ${cart.totalPoints}
        </td>
        <td>
          <form action="/order/create" method="post">
            <input type="hidden" name="userId" value="${user.userId}">
            <input type="hidden" name="cartId" value="${cartId}">
            <button type="submit">구매하기</button>
          </form>
        </td>
      </tr>
      </tfoot>
    </table>
  </section>
</main>

<%@ include file="../common/footer.jsp" %>

<script src="../../resources/static/js/cart/quantityControl.js"></script>
</body>
</html>
