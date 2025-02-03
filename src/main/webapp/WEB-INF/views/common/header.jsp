<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:48
  To change this template use File | Settings | File Templates.
  info="페이지 전반에서 사용되는 헤더 뷰 입니다. 로고, 로그인/로그아웃 버튼, 마이페이지, 장바구니와 같은 버튼이 존재합니다."
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>header</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
<header>
  <div class="square-logo">
    <form action="/" method="get">
      <button type="submit">
        <img src="../../../resources/static/images/abyssblock_square_64x64.png" alt="어비스 블록 미니멀 로고">
      </button>
    </form>
  </div>
  <ul>
    <c:choose>
      <c:when test="${isLoggedIn}">
        <li class="divider-elem">
          보유 포인트: ${user.points}
        </li>
        <li class="divider-elem">
          <form action="/user/cart/{user.cartId}" method="get">
            <input type="hidden" name="userId" value="${user.userId}">
            <button type="submit" class="btn btn-primary">
              <i class="bi bi-cart"></i>
              장바구니 <span class="badge text-bg-secondary">${cart.items}</span>
            </button>
          </form>
        </li>
        <c:choose>
          <c:when test="${isAdmin}">
            <li class="divider-elem">
              <form action="/admin/my-page" method="get">
                <button type="submit" class="btn btn-primary">관리자 페이지</button>
              </form>
            </li>
          </c:when>
          <c:otherwise>
            <li class="divider-elem">
                <%-- nav 메뉴 클릭시 쿼리 파라미터가 변경되도록 바꾸기 --%>
              <a href="/user/my-page/${user.userId}?menu=order-management" class="btn btn-primary">
                마이페이지
              </a>
            </li>
          </c:otherwise>
        </c:choose>
        <li>
          <form action="/account/logout" method="post">
            <button type="submit" class="btn btn-primary">로그아웃</button>
          </form>
        </li>
      </c:when>
      <c:otherwise>
        <li>
          <form action="/account/sign-in" method="get">
            <button type="submit" class="btn btn-primary">로그인</button>
          </form>
        </li>
      </c:otherwise>
    </c:choose>
  </ul>
</header>
</body>
</html>
