<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2025-01-14
  Time: 오후 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>회원 포인트 지급 요청 관리</title>
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
      <th>요청 번호</th>
      <th>요청 포인트</th>
      <th>요청일</th>
      <th>요청 상태</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userPointRechargeList}" var="request">
      <tr>
        <td>${request.rechargeId}</td>
        <td>${request.points}</td>
        <td><fmt:formatDate value="${request.requestTime}" pattern="yyyy-MM-dd" /></td>
        <td>${request.rechargeRequestState}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
</body>
</html>
