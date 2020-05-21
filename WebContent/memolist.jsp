<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="memo.Memo,java.util.ArrayList" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%
		ArrayList<Memo> list = (ArrayList) session.getAttribute("e");
    	session.setAttribute("list",list);
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
<h1>Memo</h1>
<ul>

<c:forEach items="${list}" var="e">

	<li><a href = "memo?mid = ${e.mid}">${e.body}</a></li>

</c:forEach>

</ul>

<br>


</body>
</html>