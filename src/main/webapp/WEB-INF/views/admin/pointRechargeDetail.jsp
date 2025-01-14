<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2025-01-14
  Time: 오후 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>포인트 충전 요청 상세 정보</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<section>
  <button id="manage-recharge-detail-button" type="button" class="btn btn-primary"
          data-bs-toggle="modal"
          data-bs-target="#manage-recharge-detail-modal">
    포인트 충전
  </button>

  <div class="modal fade" id="manage-recharge-detail-modal" tabindex="-1"
       aria-labelledby="manage-recharge-detail-modal-label"
       aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="manage-recharge-detail-modal-label">포인트 충전 요청</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal"
                  aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="alert alert-warning" role="alert">
            정확한 정보를 입력해주세요. 입력된 정보는 환불 등 처리에 사용됩니다.
          </div>
          <div class="modal-footer">
            <!-- 닫았다가 열 때 저장했던 정보가 남아있도록 or 다시 뜨도록 -->
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            <form action="/point/recharge/request/management" method="post">
              <input type="hidden" name="rechargeId" value="${request.rechargeId}">
              <input type="hidden" name="userId" value="${user.userId}">
              <input type="text" name="bank" placeholder="은행">
              <input type="text" name="accountNumber" placeholder="계좌 번호">
              <button type="submit" class="btn btn-primary">상세 정보 저장</button>
            </form>
          </div>
        </div>
      </div>
    </div>
</section>
</body>
</html>
