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
<html>
<head>
  <title>장바구니</title>
</head>
<body>
<header>
  <%@ include file="../common/header.jsp" %>
</header>
<nav>
  <a href="#">목록으로</a>
</nav>
<section>
  <table>
    <thead>
    <tr>
      <td>상품명</td>
      <td>구매 수량</td>
      <td>금액/포인트</td>
      <td>삭제</td>
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
    <button>장바구니 결제하기</button>
  </form>
</section>
<footer>
  <%@ include file="../common/footer.jsp" %>
</footer>
</body>
</html>
