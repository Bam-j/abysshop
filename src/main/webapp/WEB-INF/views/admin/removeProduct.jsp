<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:23
  To change this template use File | Settings | File Templates.
  info="관리자 페이지의 상품 삭제 뷰 입니다."
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>상품 삭제</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
<section>
  <table>
    <thead>
    <tr>
      <td>상품 번호</td>
      <td>상품명</td>
      <td>가격</td>
      <td>삭제</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product">
      <tr>
        <td>${product.productId}</td>
        <td>${product.productName}</td>
        <td>${product.price}</td>
        <td>
          <form action="/admin/product/remove" method="post">
            <input type="hidden" name="productId" value="${product.productId}">
            <button type="submit" class="btn btn-warning">품목 삭제</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <%-- 페이지네이션 UI --%>
  <div class="pagination">
    <%-- 이전 버튼 (첫 페이지가 아닐 때만 활성화) --%>
    <c:if test="${currentPage > 1}">
      <a href="?page=${currentPage - 1}" class="page-link">이전</a>
    </c:if>

    <%-- 페이지 번호 표시 --%>
    <c:forEach var="i" begin="1" end="${totalPages}">
      <a href="?page=${i}" class="page-link ${i == currentPage ? 'active' : ''}">${i}</a>
    </c:forEach>

    <%-- 다음 버튼 (마지막 페이지가 아닐 때만 활성화) --%>
    <c:if test="${currentPage < totalPages}">
      <a href="?page=${currentPage + 1}" class="page-link">다음</a>
    </c:if>
  </div>

</section>
</body>
</html>
