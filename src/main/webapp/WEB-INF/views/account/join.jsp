<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    info="사용자 회원가입 폼 페이지입니다."
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <title>회원 가입</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<nav>
  <form action="" method="get">
    <button type="button" class="btn btn-outline-dark">
      <i class="bi bi-arrow-left"></i>로그인
    </button>
  </form>
</nav>
<main>
  <section>
    <div id="logo">
      <img src="" alt="어비스블록 로고">
    </div>
    <%-- TODO: action을 요청 방식 결정하고 변경할 것. 현재는 임시 요청 사용 --%>
    <form action="/account/join" method="post">
      <input type="text" placeholder="계정">
      <input type="text" data-bs-toggle="tooltip" data-bs-placement="bottom"
             data-bs-custom-class="custom-tooltip"
             data-bs-title="주의! 반드시 인게임의 마인크래프트 닉네임과 동일한 닉네임을 적어주세요. 후원이 원활하게 이루어지지 않을 수 있습니다."
             placeholder="마인크래프트 닉네임">
      <%-- TODO: 개발 완료시 type:"password"로 비밀번호 입력 가리기 --%>
      <input type="text" placeholder="비밀번호">
      <button type="submit" class="btn btn-primary">회원가입</button>
    </form>
    <hr>
    <form action="/account/login" method="get">
      <button type="submit" class="btn btn-primary">로그인</button>
    </form>
  </section>
</main>
</body>
</html>
