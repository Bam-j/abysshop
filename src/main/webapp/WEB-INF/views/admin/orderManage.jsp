<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:04
  To change this template use File | Settings | File Templates.
  info="관리자 페이지의 주문 관리 뷰 입니다."
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
  <title>관리자 주문 관리</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<section>
  <table>
    <thead>
    <tr>
      <th>주문 번호</th>
      <th>주문 상품</th>
      <th>주문 금액/포인트</th>
      <th>구매일</th>
      <th>주문 상태</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderHistory}" var="order">
      <tr>
        <td>${order.orderId}</td>
        <td>${order.orderItems}</td>
        <td>${order.totalAmount}</td>
        <td>${order.orderDate}</td>
        <td>
          <form>
            <select id="orderState">
              <option value="payment_pending" selected>결제 확인 대기</option>
              <option value="ready_for_delivery">상품 전달 대기</option>
              <option value="delivered">상품 전달 완료</option>
            </select>
            <button>변경</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
</body>
</html>
