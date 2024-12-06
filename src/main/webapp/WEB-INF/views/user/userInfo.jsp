<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 7:53
  To change this template use File | Settings | File Templates.
  info="사용자 계정 정보를 확인/수정하는 뷰 입니다."
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"
        pageEncoding="UTF-8"
%>
<html>
<head>
    <title>회원 정보 관리</title>
</head>
<body>
<form action="/account/change/nickname">
    <input type="text" aria-placeholder="변경할 닉네임 입력">
    <small>주의! 반드시 인게임의 마인크래프트 닉네임과 동일한 닉네임을 적어주세요. 후원이 원활하게 이루어지지 않을 수 있습니다.</small>
    <button type="submit">닉네임 변경</button>
</form> <hr>
<form action="/account/change/password" method="post">
    <%-- TODO: 개발 완료시 type:"password"로 비밀번호 입력 가리기 --%>
    <input type="text" aria-placeholder="변경할 비밀번호 입력">
    <button type="submit">비밀번호 변경</button>
</form> <hr>
<form action="/account/withdraw">
    <%-- TODO: 개발 완료시 type:"password"로 비밀번호 입력 가리기 --%>
    <input type="text" aria-placeholder="비밀번호 입력">
    <button type="submit">회원탈퇴</button>
</form>
</body>
</html>
