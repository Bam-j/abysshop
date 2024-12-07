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
<html>
<head>
  <title>관리자 주문 관리</title>
</head>
<body>
<section>
  <table>
    <thead>
    <tr>
      <td>주문 번호</td>
      <td>주문 상품</td>
      <td>주문 금액/포인트</td>
      <td>구매일</td>
      <td>주문 상태</td>
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
