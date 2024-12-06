<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page
        info="사용자의 개인 마이 페이지입니다. 주문 내역(default), 사용자 정보 관리를 할 수 있습니다."
        contentType="text/html;charset=UTF-8"
        language="java"
        pageEncoding="UTF-8"
%>
<html>
<head>
    <title>마이 페이지</title>
</head>
<body>
<header>
    <%@ include file="../common/header.jsp" %>
</header>
<nav>
    <%@ include file="userMyPageNav.jsp" %>
</nav>
<section>
    <jsp:include page="userOrder.jsp"/>
</section>
<footer>
    <%@ include file="../common/footer.jsp" %>
</footer>
</body>
</html>
