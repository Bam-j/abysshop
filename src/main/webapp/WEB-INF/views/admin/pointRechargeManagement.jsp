<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2025-01-14
  Time: 오후 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>포인트 지급 요청 관리</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
<section>
  <h3><strong>반드시 포인트 지급 전에 요청 상세 정보에 정보를 입력해주세요</strong></h3>
  <table>
    <thead>
    <tr>
      <th>주문 번호</th>
      <th>요청자</th>
      <th>요청 포인트</th>
      <th>요청일</th>
      <th>요청 상태</th>
      <th>요청 상세 정보</th>
      <th>요청 승인</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pointRechargeList}" var="pointRecharge">
      <tr>
        <td>${pointRecharge.rechargeId}</td>
        <td>${pointRecharge.nickname}</td>
        <td>${pointRecharge.points}</td>
        <td>${pointRecharge.requestTime}</td>
        <td>
          <div class="btn-group">
            <button type="button" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown"
                    aria-expanded="false">
                ${pointRecharge.rechargeRequestState} <!-- TODO: state값에 따라 한글 상태가 출력되도록 변경 -->
            </button>
            <ul class="dropdown-menu">
              <li>
                <a class="dropdown-item" data-value="pending-payment" href="#">송금 확인 대기</a>
              </li>
              <li>
                <a class="dropdown-item" data-value="pending-point-deposit" href="#">포인트 지급 대기</a>
              </li>
              <li>
                <a class="dropdown-item" data-value="completed" href="#">포인트 지급 완료</a>
              </li>
              <li>
                <a class="dropdown-item" data-value="refunded" href="#">환불 처리 완료</a>
              </li>
            </ul>
            <form action="/point/recharge/change-state" method="post">
              <input type="hidden" name="rechargeId" value="${pointRecharge.rechargeId}">
              <input type="hidden" name="newState" id="newState" />
              <button type="submit" class="btn btn-primary">변경</button>
            </form>
          </div>
        </td>
        <td>
          <%@ include file="pointRechargeDetail.jsp" %>
        </td>
        <td>
          <form action="/admin/point/provide" method="post">
            <button type="submit">지급 승인</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
</body>
</html>
