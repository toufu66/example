<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "sankaku.Sankaku" %>
<% Sankaku s = (Sankaku) session.getAttribute("s"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
面積:${s.menseki}
</body>
</html>