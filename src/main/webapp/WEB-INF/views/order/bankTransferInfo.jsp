<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    info="포인트 주문 후 이체용 계좌를 표시하는 페이지입니다."
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <title>결제</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../../../resources/static/styles/common/base.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="../common/header.jsp" %>
<main>
  <section>
    <div class="logo">
      <img src="../resources/static/images/abyssblock_mark_280x280.png" alt="abyssblock 로고">
    </div>
    <div>
      <h2>계좌 번호를 여기에 작성</h2>
      <ol>
        <li><strong>반드시 아래 안내문을 읽고 송금을 한 후 송금 완료 버튼을 클릭해주세요.</strong></li>
        <li>송금자 명을 닉네임과 동일하게 설정해주세요.</li>
        <li>입금 후 포인트/상품 지급까지 5분에서 최대 20분까지 소요될 수 있습니다.</li>
        <li>결제 과정에서 문의는 디스코드에서 받고있습니다.</li>
      </ol>
    </div>
    <form action="/payment/complete" method="get">
      <button type="button" class="btn btn-primary">결제 완료</button>
    </form>
  </section>
</main>
<%@ include file="../common/footer.jsp" %>
</body>
</html>