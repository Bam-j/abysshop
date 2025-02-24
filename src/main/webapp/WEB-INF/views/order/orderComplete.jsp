<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    info="계좌 이체 페이지 다음 또는 장바구니에서 상품 결제 후 나타나는 주문 완료 페이지입니다."
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <title>결제 완료</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.3/dist/cerulean/bootstrap.min.css"
        rel="stylesheet">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/common.css">
  <link rel="stylesheet" href="../../../resources/static/styles/order/orderComplete.css">
  <%--<link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">--%>
</head>
<body>
<main>
  <section>
    <div class="mark-logo">
      <img src="../resources/static/images/abyssblock_mark_sd.png" alt="abyssblock 로고">
    </div>
    <h3>주문이 완료되었습니다.</h3>
    <div>
      <ol>
        <li>주문 상태는 '마이 페이지'의 '주문 관리' 또는 '포인트 지급 요청'에서 확인하실 수 있습니다.</li>
        <li>입금 후 포인트/상품 지급까지 5분에서 최대 24시간까지 소요될 수 있습니다.</li>
        <li>결제 과정에서 문의는 디스코드에서 받고있습니다.</li>
      </ol>
    </div>
    <a type="button" class="btn btn-primary" href="/">
      <i class="bi bi-house-door"></i> 메인으로
    </a>
    <a type="button" class="btn btn-success"
       href="/user/my-page/${user.userId}?menu=order-management">
      <i class="bi bi-card-list"></i> 주문 내역으로
    </a>
  </section>
</main>
</body>
</html>
