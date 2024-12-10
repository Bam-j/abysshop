<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    info="사용자가 장바구니에 담은 상품 목록들을 보여주는 페이지입니다."
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>장바구니</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="../common/header.jsp" %>
<nav>
  <a href="#">목록으로</a>
</nav>
<main>
  <section>
    <table>
      <thead>
      <tr>
        <th>상품명</th>
        <th>구매 수량</th>
        <th>금액/포인트</th>
        <th>삭제</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${shoppingCart}" var="item">
        <tr>
          <td>${item.name}</td>
          <td>${item.quantity}</td>
          <td>${item.price}</td>
          <td><a href="#">삭제</a></td>
        </tr>
      </c:forEach>
      </tbody>
      <tfoot>
      <tr>
        <td>합계</td>
        <td>0000</td>
      </tr>
      </tfoot>
    </table>
    <form action="/payment/instructions" method="post">
      <button type="button" class="btn btn-primary">장바구니 결제하기</button>
    </form>
  </section>
</main>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
