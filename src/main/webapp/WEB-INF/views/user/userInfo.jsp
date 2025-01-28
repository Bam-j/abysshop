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
<!DOCTYPE html>
<html>
<head>
  <title>회원 정보 관리</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
<section>
  <hr>
  <form action="/account/change/nickname" method="post">
    <div class="alert alert-danger" role="alert">
      반드시 인게임 닉네임과 동일한 닉네임으로 설정해주세요. <br>
      후원 과정에서 문제가 발생할 가능성이 높습니다.
    </div>
    <input type="hidden" name="userId" value="${user.userId}">
    <input type="text" name="newNickname" placeholder="변경할 닉네임 입력">
    <button type="submit" class="btn btn-primary">닉네임 변경</button>
  </form>
  <hr>
  <form action="/account/change/password" method="post">
    <input type="hidden" name="userId" value="${user.userId}">
    <%-- TODO: 개발 완료시 type:"password"로 비밀번호 입력 가리기 --%>
    <input type="text" name="newPassword" placeholder="변경할 비밀번호 입력">
    <button type="submit" class="btn btn-primary">비밀번호 변경</button>
  </form>

  <hr>

  <button id="withdraw-button" type="button" class="btn btn-danger" data-bs-toggle="modal"
          data-bs-target="#withdraw-modal">
    회원 탈퇴
  </button>

  <div class="modal fade" id="withdraw-modal" tabindex="-1" aria-labelledby="withdraw-modal-label"
       aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="withdraw-modal-label">회원 탈퇴 확인</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal"
                  aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="alert alert-warning" role="alert">
            탈퇴 하시려면 현재 비밀번호를 입력해주세요.
          </div>
          <input type="text" placeholder="현재 비밀번호">
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
          <form action="/account/withdraw" method="post">
            <input type="hidden" name="userId" value="${user.userId}">
            <button type="submit" name="password" class="btn btn-danger">회원 탈퇴</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>
