<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:55
  To change this template use File | Settings | File Templates.
  info="상품 목록, 포인트 목록으로 이동할 수 있는 메뉴 바 입니다."
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"
        pageEncoding="UTF-8"
%>
<html>
<head>
    <title>상품 목록 전환 메뉴바</title>
</head>
<body>
<nav class="menuBar">
    <ul>
        <%-- 해당 메뉴 선택시 볼드체로 나타나도록 --%>
        <li><a href="#">상품</a></li>
        <li><a href="#">포인트</a></li>
    </ul>
</nav>
</body>
</html>
