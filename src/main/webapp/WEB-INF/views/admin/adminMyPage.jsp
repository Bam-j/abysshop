<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    info="관리자 페이지입니다."
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<html>
<head>
  <title>관리자 페이지</title>
  <link rel="shortcut icon" href="/static/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="../common/header.jsp" %>

<%@ include file="adminPageNav.jsp" %>

<main>
  <jsp:include page="orderManage.jsp" />
</main>

<%@ include file="../common/footer.jsp" %>
</body>
</html>
