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
<html>
<head>
    <title>회원 가입</title>
</head>
<body>
<header>
    <img src="../../../images/abyssblock_logo_1500x700.png" alt="abyssblock 로고">
</header>
<section>
    <%-- TODO: action을 요청 방식 결정하고 변경할 것. 현재는 임시 요청 사용 --%>
    <form action="/account/join" method="post">
        <input type="text" placeholder="계정">
        <input type="text" placeholder="마인크래프트 닉네임">
        <small>주의! 반드시 인게임의 마인크래프트 닉네임과 동일한 닉네임을 적어주세요. 후원이 원활하게 이루어지지 않을 수 있습니다.</small>
        <%-- TODO: 개발 완료시 type:"password"로 비밀번호 입력 가리기 --%>
        <input type="text" placeholder="비밀번호">
        <button type="submit">회원가입</button>
    </form> <hr>
    <form action="/account/login" method="get">
        <button type="submit">로그인</button>
    </form>
</section>
</body>
</html>
