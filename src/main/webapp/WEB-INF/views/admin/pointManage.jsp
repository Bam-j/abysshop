<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:05
  To change this template use File | Settings | File Templates.
  info="관리자 페이지의 포인트 관리 뷰 입니다."
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
  <title>포인트 관리 페이지</title>
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
      <th>회원 닉네임</th>
      <th>요청 포인트</th>
      <th>이체 확인 후 버튼 클릭</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pointsRechargeRequest}" var="request">
      <tr>
        <td>${request.nickname}</td>
        <td>${request.points}</td>
        <td>
          <form>
            <button>승인</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
</body>
</html>
