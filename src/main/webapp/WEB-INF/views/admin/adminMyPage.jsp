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
<!DOCTYPE html>
<html>
<head>
  <title>관리자 페이지</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/common.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/header.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/footer.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/table.css">
  <link rel="stylesheet" href="../../../resources/static/styles/admin/addProduct.css">
  <link rel="stylesheet" href="../../../resources/static/styles/admin/removeProduct.css">
  <%--<link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">--%>
</head>
<body>
<%@ include file="../common/header.jsp" %>

<%@ include file="adminPageNav.jsp" %>

<main>
  <div id="content">
    <c:choose>
      <c:when test="${param.menu eq 'point-recharge-management'}">
        <jsp:include page="pointRechargeManagement.jsp" />
      </c:when>
      <c:when test="${param.menu eq 'add-productEntity'}">
        <jsp:include page="addProduct.jsp" />
      </c:when>
      <c:when test="${param.menu eq 'remove-productEntity'}">
        <jsp:include page="removeProduct.jsp" />
      </c:when>
      <c:otherwise>
        <jsp:include page="orderManagement.jsp" />
      </c:otherwise>
    </c:choose>
  </div>
</main>

<%@ include file="../common/footer.jsp" %>
</body>
</html>
