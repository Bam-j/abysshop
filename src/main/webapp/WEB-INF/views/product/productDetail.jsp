<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    info="상품, 포인트의 상세 페이지입니다."
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%
  //TODO: 추후 DB id 저장값에 따라서 자료형 변경하기
  String id = (String) session.getAttribute("productId");
  //id를 사용하여 DB로부터 상품 정보(이미지, 이름, 가격, 설명) 취득
%>
<!DOCTYPE html>
<html>
<head>
  <title>상품 상세 페이지</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<%-- 상품 이미지, 상품명, 가격, 상품 상세 설명, 수량, 장바구니 담기 버튼 --%>
<%@ include file="../common/header.jsp" %>
<nav>
  <a href="#">목록으로</a>
</nav>
<main>
  <section>
    <ul>
      <li><img src="${product.imgUrl}" alt="상품 이미지"></li>
      <li><h2><strong>${product.name}</strong></h2></li>
      <li><h3>${product.price}</h3></li>
      <li>${product.description}</li>
    </ul>
  </section>
</main>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
