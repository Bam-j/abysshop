<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-01
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.

  메모: 두 가지 include 방식 (추후 삭제)
  <%@ include file=""%>: 컴파일 시점에 include, 헤더 푸터와 같은 변경이 적은 부분 적용시
  <jsp:include page=""/> 실행 시점에 include, 동적 변경 내용이 포함될 때 사용
--%>
<%@ page
    info="Abysshop의 메인 페이지입니다. 상품 목록을 보여줍니다."
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Abysshop 홈</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../resources/static/styles/common/base.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="common/header.jsp" %>

<%-- default는 상품 --%>
<%@ include file="product/productNav.jsp" %>

<main>
  <section>
    <div id="carouselExampleIndicators" class="carousel slide">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                class="active" aria-current="true" aria-label="Slide 1"></button>
        <%--  carousel에 컨텐츠 추가시 아래 코드를 copy & paste
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
        --%>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="../resources/static/images/abyssblock_logo.png" class="d-block w-100"
               alt="abyssblock_logo.png">
        </div>
        <%--  carousel에 컨텐츠 추가시 아래 코드를 copy & paste
        <div class="carousel-item">
          <img src="..." class="d-block w-100" alt="...">
        </div>
        --%>
      </div>
      <button class="carousel-control-prev" type="button"
              data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button"
              data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </section>

  <jsp:include page="product/productPurchase.jsp" />
</main>

<%@ include file="common/footer.jsp" %>
</body>
</html>
