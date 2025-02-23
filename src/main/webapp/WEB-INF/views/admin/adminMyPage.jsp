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
    isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <link rel="stylesheet" href="../../../resources/static/style/common/pagination.css">
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
      <c:when test="${param.menu eq 'point-recharge-detail'}">
        <jsp:include page="pointRechargeDetail.jsp" />
      </c:when>
      <c:when test="${param.menu eq 'add-product'}">
        <jsp:include page="addProduct.jsp" />
      </c:when>
      <c:when test="${param.menu eq 'remove-product'}">
        <jsp:include page="removeProduct.jsp" />
      </c:when>
      <c:otherwise>
        <jsp:include page="orderManagement.jsp" />
      </c:otherwise>
    </c:choose>
  </div>
</main>

<%@ include file="../common/footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script src="../../resources/static/js/common/navEvent.js"></script>
<%-- TODO: 요청 상대가 처음에만 번역되고 탭 이동 후에는 영어로 나옴. (스크립트 로드 방법 찾기) --%>
<script src="../../resources/static/js/common/translateStateToKOR.js"></script>
<script src="../../resources/static/js/admin/changeState.js"></script>
<script src="../../resources/static/js/admin/addProductValidation.js"></script>
</body>
</html>
