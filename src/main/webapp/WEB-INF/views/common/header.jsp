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
  <link rel="stylesheet" href="../../../resources/static/styles/common/base.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/header.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<%
  boolean isLoggedIn = false;
%>
<header>
  <div class="square-logo">
    <a href="../index.jsp">
      <img src="../static/images/abyssblock_square_64x64.png" alt="어비스 블록 미니멀 로고">
    </a>
  </div>
  <ul>
    <% if (isLoggedIn) { %>
    <li>
      <button type="button" class="btn btn-primary">
        <i class="bi bi-cart"></i>
        장바구니 <span class="badge text-bg-secondary">${cart.items}</span>
      </button>
    </li>
    <li>
      <%-- TODO: 일반 회원은 userMyPage.jsp로 이동하고 관리자는 adminMyPage.jsp로 이동 --%>
      <button type="submit" class="btn btn-primary">마이페이지</button>
    </li>
    <li>
      <button type="submit" class="btn btn-primary">로그아웃</button>
    </li>
    <% } else { %>
    <li>
      <button type="submit" class="btn btn-primary">로그인</button>
    </li>
    <% } %>
  </ul>
</header>
</body>
</html>
