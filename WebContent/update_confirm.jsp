<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db_club.Member,java.util.ArrayList" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%
		Member m = (Member) request.getAttribute("m");
    %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<meta charset="UTF-8">
<title>変更確認</title>
</head>
<body>

<form action ="update" method = "post">
	ID :${m.mid}<br>
	<input type = "hidden" name = "mid" value = "${m.mid}">
	${m.name} :<input type="text" name = "name" ><br>
	${m.address} :<input type="text" name = "address" ><br>
	<input type = "submit" value = "更新"> <br>
</form>

<form action ="delete" method = "post">
	<input type = "hidden" name = "mid" value = "${m.mid}">
	<input type = "submit" value = "削除"> <br>
</form>


</body>
</html>