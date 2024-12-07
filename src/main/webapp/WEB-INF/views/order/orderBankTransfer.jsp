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
<html>
<head>
  <title>결제</title>
  <link rel="shortcut icon" href="/static/favicon.ico" type="image/x-icon">
</head>
<body>
<%@ include file="../common/header.jsp" %>
<main>
  <section>
    <div class="logo">
      <img src="" alt="abyssblock 로고">
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
      <button>결제 완료</button>
    </form>
  </section>
</main>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
