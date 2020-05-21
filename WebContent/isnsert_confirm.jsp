<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db_club.Member,java.util.ArrayList" %>

<%
Member e = (Member) request.getAttribute("e");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力確認</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

%>
${e.name} ${e.address}
を追加しますか？
<form action ="MemberInsert" method = "get">

氏名 <input type = "text" name = "name"><br>
住所 <input type = "text" name = "address"><br>

<input type = "submit" value = "登録"> <br>
</form>


</body>
</html>