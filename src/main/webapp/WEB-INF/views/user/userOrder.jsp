<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 7:54
  To change this template use File | Settings | File Templates.
  info="사용자의 주문 내역 리스트를 보여주는 뷰 입니다."
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>주문 관리</title>
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
        <%-- orderItems: 3건 이상은 [상품명 외 n건]으로 표시하기 --%>
        <td>${order.orderItems}</td>
        <td>${order.totalAmount}</td>
        <td>${order.orderDate}</td>
        <td>${order.orderState}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
</body>
</html>
