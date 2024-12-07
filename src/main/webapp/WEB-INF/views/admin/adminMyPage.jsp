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
</head>
<body>
<header>
  <%@ include file="../common/header.jsp" %>
</header>
<nav>
  <%@ include file="adminPageNav.jsp" %>
</nav>
<section>
  <jsp:include page="orderManage.jsp" />
</section>
<footer>
  <%@ include file="../common/footer.jsp" %>
</footer>
</body>
</html>
