<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db_club.Member,java.util.ArrayList" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%
		ArrayList<Member> list = (ArrayList) request.getAttribute("e");
    	request.setAttribute("list",list);
    %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<title>会員リスト</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

%>
<table>
<tr><th>名前</th><th>住所</th></tr>
<c:forEach items="${list}" var="e">
	<tr>
	<td>${e.name}</td>
	<td>${e.address}</td>
	<c:if test = "${not empty user}">
	<td> <a href = "update?mid=${e.mid}">更新/削除</a></td>
	</c:if>
	</tr>
</c:forEach>

</table>
<c:if test = "${not empty user}">

<form action ="insert" method = "get">

氏名 <input type = "text" name = "name"><br>
住所 <input type = "text" name = "address"><br>

<input type = "submit" value = "登録"> <br>
</form>
</c:if>
<br>


</body>
</html>