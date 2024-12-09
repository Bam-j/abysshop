<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:54
  To change this template use File | Settings | File Templates.
  info="회원의 개인 페이지의 nav에서 사용되는 메뉴 바입니다."
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <title>일반 회원 마이페이지 메뉴바</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<nav>
  <ul>
    <%-- 해당 메뉴 선택시 볼드체로 나타나도록 --%>
    <li><a href="#">주문 관리</a></li>
    <li><a href="#">회원 정보 관리</a></li>
  </ul>
</nav>
</body>
</html>
