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
<html>
<head>
  <title>header</title>
</head>
<body>
<%
  boolean isLoggedIn = false;
%>
<header>
  <div class="logo">
    <a href="../../index.jsp">
      <img src="" alt="어비스 블록 로고">
    </a>
  </div>
  <ul>
    <% if (isLoggedIn) { %>
    <li>
      <%-- TODO: 일반 회원은 userMyPage.jsp로 이동하고 관리자는 adminMyPage.jsp로 이동 --%>
      <button>마이페이지</button>
    </li>
    <li>
      <button>로그아웃</button>
    </li>
    <% } else { %>
    <li>
      <button>로그인</button>
    </li>
    <% } %>
  </ul>
</header>
</body>
</html>
