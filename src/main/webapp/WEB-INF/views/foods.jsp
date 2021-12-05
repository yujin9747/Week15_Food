<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.team16.foodapp.food.FoodDAO,com.team16.foodapp.food.FoodVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>food list</title>
<!-- Style ³Ö±â -->
<script>
	function delete_ok(id){
		var a = confirm("Á¤¸»·Î »èÁ¦ÇÏ°Ú½À´Ï±î?(Æó±âÀÏÀÌ Áö³µ°Å³ª ¼ÒÁøÇß´ÂÁö Á¡°ËÇØº¸¼¼¿ä.)");
		if(a) location.href='deleteok/' + id;
	}
</script>
</head>
<body>
<h1>Food list</h1>

<table id="list" width="90%">
<tr>
	<th>Id</th>
	<th>Food</th>
	<th>Memo</th>
	<th>Date</th>
	<th>Expired?</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach items="${list}" var="u">
	<tr>
		<td>${u.id}</td>
		<td>${u.name}</td>
		<td>${u.memo}</td>
		<td>${u.date}</td>
		<td>${u.expired}</td>
		<td><button type = "button" onclick="location.href='editpost/${u.seq}'" >¼öÁ¤</button></td>
		<td><button type = "button" onclick="javascript:delete_ok('${u.id}')">Æó±â</button></td>
	</tr>
</c:forEach>
</table>
<br/><button type = "button"  onclick="location.href='add'">Ãß°¡ÇÏ±â</button>
</body>
</html>