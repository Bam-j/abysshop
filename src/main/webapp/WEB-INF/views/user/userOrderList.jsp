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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원 주문 관리</title>
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
      <th>주문 번호</th>
      <th>주문 총 포인트</th>
      <th>구매일</th>
      <th>주문 상태</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userOrderList}" var="order">
      <tr>
        <td>${order.orderId}</td>
        <td>${order.totalPoints}</td>
        <td><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd" /></td>
        <td>${order.orderState}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
</body>
</html>
