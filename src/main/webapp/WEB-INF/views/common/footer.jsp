<%--
  Created by IntelliJ IDEA.
  User: juhyu
  Date: 2024-12-03
  Time: 오후 8:59
  To change this template use File | Settings | File Templates.
  info="페이지 전반에서 사용되는 푸터 뷰 입니다. 로고, 서버 주소, 디스코드 주소 등이 포함됩니다."
--%>
<%@ page
    contentType="text/html;charset=UTF-8"
    language="java"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
  <title>footer</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="shortcut icon" href="../../../resources/static/favicon.ico" type="image/x-icon">
</head>
<body>
<footer>
  <div class="square-logo">
    <a href="../index.jsp">
      <img src="../static/images/abyssblock_square_64x64.png" alt="어비스 블록 미니멀 로고">
    </a>
  </div>
  <ul>
    <li class="divider-elem">서버 주소</li>
    <li>디스코드 주소</li>
  </ul>
</footer>
</body>
</html>
