<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="memo.Memo,java.util.ArrayList" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%
		Memo e = (Memo) session.getAttribute("e");
    %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<title>Memo List</title>
</head>

<body>
<%
	request.setCharacterEncoding("UTF-8");

%>
<h1>${e.title}</h1>

<p>${e.body}</p><br>
<a href = "memolist">戻る</a>


</body>
</html>