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
<html>
<head>
  <title>결제 완료</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<main>
  <section>
    <div>
      <img src="" alt="abyssblock 로고">
    </div>
    <h3>결제가 완료되었습니다.</h3>
    <div>
      <ol>
        <li>주문 상태는 '마이 페이지'의 '주문 관리'에서 확인하실 수 있습니다.</li>
        <li>입금 후 포인트/상품 지급까지 5분에서 최대 20분까지 소요될 수 있습니다.</li>
        <li>결제 과정에서 문의는 디스코드에서 받고있습니다.</li>
      </ol>
    </div>
    <form action="/" method="get">
      <button>메인으로</button>
    </form>
    <form action="/" method="get">
      <button>주문 내역으로</button>
    </form>
  </section>
</main>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
