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
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/nav.css">
</head>
<body>
<nav class="nav">
  <a class="nav-link active" aria-current="page"
     href="/user/my-page/${user.userId}?menu=order-management">주문 관리</a>
  <a class="nav-link" href="/user/my-page/${user.userId}?menu=user-info">계정 관리</a>
  <a class="nav-link" href="/user/my-page/${user.userId}?menu=point-request">포인트 지급 요청</a>
</nav>
</body>
</html>
