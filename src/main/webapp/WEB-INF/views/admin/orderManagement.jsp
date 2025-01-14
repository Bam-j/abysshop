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
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/table.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<section>
  <table>
    <thead>
    <tr>
      <th>주문 번호</th>
      <th>주문자</th>
      <th>주문 상품</th>
      <th>주문 포인트</th>
      <th>구매일</th>
      <th>주문 상태</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderHistory}" var="order">
      <tr>
        <td>${order.orderId}</td>
        <td>${order.customer}</td>
        <td>${order.items}</td>
        <td>${order.totalAmount}</td>
        <td>${order.date}</td>
        <td>
          <div class="btn-group">
            <button type="button" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown"
                    aria-expanded="false">
                ${order.state} <!-- TODO: state값에 따라 한글 상태가 출력되도록 변경 -->
            </button>
            <ul class="dropdown-menu">
              <li>
                <a class="dropdown-item" data-value="shipping" href="#">상품 지급 대기</a>
              </li>
              <li>
                <a class="dropdown-item" data-value="completed" href="#">상품 지급 완료</a>
              </li>
              <li>
                <a class="dropdown-item" data-value="refunded" href="#">환불 처리 완료</a>
              </li>
            </ul>
            <form action="/admin/order/goods/change-state" method="post">
              <input type="hidden" name="orderId" value="${order.orderId}">
              <input type="hidden" name="newState" id="newState" />
              <button type="submit" class="btn btn-primary">변경</button>
            </form>
          </div>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
</body>
</html>
