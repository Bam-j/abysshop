<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2025-02-10
  Time: 오후 4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>포인트 충전 요청 상세 정보</title>
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
      <th>요청 정보 번호</th>
      <th>요청 번호</th>
      <th>주문자</th>
      <th>입금 확인 일</th>
      <%-- TODO: 입금액 컬럼 추가를 고려해보자 --%>
      <th>은행</th>
      <th>계좌 번호</th>
      <th>입력 제출</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pointRechargeDetailList}" var="pointRechargeDetail"
               varStatus="status">
      <tr data-index="${status.index}">
        <td>${pointRechargeDetail.rechargeDetailId}</td>
        <td>${pointRechargeDetail.rechargeId}</td>
        <td>${pointRechargeDetail.nickname}</td>
        <td><fmt:formatDate value="${pointRechargeDetail.depositConfirmedTime}"
                            pattern="yyyy-MM-dd" /></td>
        <form action="/point/recharge/detail" method="post">
          <td><input type="text"
                     name="bank"
                     value="${pointRechargeDetail.bank != null ? pointRechargeDetail.bank : ''}"
                     placeholder="은행" /></td>
          <td><input type="text"
                     name="accountNumber"
                     value="${pointRechargeDetail.accountNumber != null ? pointRechargeDetail.accountNumber : ''}"
                     placeholder="계좌번호" /></td>
          <td>
            <input type="hidden" name="rechargeDetailId"
                   value="${pointRechargeDetail.rechargeDetailId}" data-index="${status.index}" />
            <button type="submit" data-index="${status.index}">입력</button>
          </td>
        </form>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
</body>
</html>
