<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:48
  To change this template use File | Settings | File Templates.
  info="페이지 전반에서 사용되는 헤더 뷰 입니다. 로고, 로그인/로그아웃 버튼, 마이페이지, 장바구니와 같은 버튼이 존재합니다."
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>header</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<%
  //TODO: DB에선 TINYINT(1)로 표기하므로 boolean 타입 추후에 변경
  //c:set 사용
  boolean isLoggedIn = false;
  boolean isAdmin = false;
%>
<header>
  <div class="square-logo">
    <a href="../index.jsp">
      <img src="../static/images/abyssblock_square_64x64.png" alt="어비스 블록 미니멀 로고">
    </a>
  </div>
  <ul>
    <c:choose>
      <c:when test="${isLoggedIn}">
        <li class="divider-elem">
          <button type="button" class="btn btn-primary">
            <i class="bi bi-cart"></i>
            장바구니 <span class="badge text-bg-secondary">${cart.items}</span>
          </button>
        </li>
        <c:choose>
          <c:when test="${isAdmin}">
            <li class="divider-elem">
              <button type="submit" class="btn btn-primary">관리자 페이지</button>
            </li>
          </c:when>
          <c:otherwise>
            <li class="divider-elem">
              <button type="submit" class="btn btn-primary">마이페이지</button>
            </li>
          </c:otherwise>
        </c:choose>
        <li>
          <button type="submit" class="btn btn-primary">로그아웃</button>
        </li>
      </c:when>
      <c:otherwise>
        <li>
          <button type="submit" class="btn btn-primary">로그인</button>
        </li>
      </c:otherwise>
    </c:choose>
  </ul>
</header>
</body>
</html>
