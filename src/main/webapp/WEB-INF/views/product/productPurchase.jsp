<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:01
  To change this template use File | Settings | File Templates.
  info="상품 리스트를 보여주는 뷰 입니다. 리스트의 항목을 클릭하면 해당 물품의 상세 페이지로 이동합니다."
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"
        pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>상품 목록</title>
</head>
<body>
<%-- 상품 이미지, 상품명, 가격 --%>
<h3>상품 목록</h3>

<table class="itemList">
    <tbody>
    <c:forEach items="${productList}" var="product">
        <%-- TODO: 추후 onclick 이벤트 js파일로 분리할 것 --%>
        <tr onclick="location.href='productDetail.jsp?productId=${product.id}'">
            <td><img src="${product.imgUrl}" alt="${product.imgUrl}"></td>
            <td>${product.name}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
