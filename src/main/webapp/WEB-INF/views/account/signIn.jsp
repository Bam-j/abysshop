<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    info="회원 로그인 폼 페이지입니다."
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <title>로그인</title>
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
<nav>
  <form action="/" method="get">
    <button type="button" class="btn btn-outline-dark">
      <i class="bi bi-arrow-left"></i>메인으로
    </button>
  </form>
</nav>
<main>
  <div id="logo">
    <img src="../resources/static/images/abyssblock_mark_280x280.png" alt="어비스블록 로고">
  </div>
  <section>
    <%-- TODO: action을 요청 방식 결정하고 변경할 것. 현재는 임시 요청 사용 --%>
    <form action="/account/sign-in" method="post">
      <input type="text" placeholder="계정">
      <%-- TODO: 개발 완료시 type:"password"로 비밀번호 입력 가리기 --%>
      <input type="text" placeholder="비밀번호">
      <button type="submit" class="btn btn-primary">로그인</button>
    </form>
    <hr>
    <form action="/account/sign-up" method="get">
      <button type="submit" class="btn btn-secondary">회원가입</button>
    </form>
  </section>
</main>
</body>
</html>
