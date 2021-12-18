<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.team16.foodapp.food.FoodDAO,com.team16.foodapp.food.FoodVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>food list</title>
<style>
#list {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#list td, #list th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align:center;
}
#list tr:nth-child(even){background-color: #f2f2f2;}
#list tr:hover {background-color: #ddd;}
#list th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #006bb3;
  color: white;
}
</style>
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?");
		if(a) location.href='deleteok/' + id;
	}
	function complete_ok(id){
		var a = confirm("재료를 모두 소진하셨습니까?");
		if(a) location.href='completeok/' + id;
	}
</script>
</head>
<body>
<h1>자유게시판</h1>

<table id="list" width="90%">
<tr>
	<th>Id</th>
	<th>Food</th>
	<th>Memo</th>
	<th>Date</th>
	<th>Comp</th>
	<th>Inventory</th>
	<th>Price</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach items="${list}" var="u">
	<tr>
		<td>${u.id}</td>
		<td>${u.name}</td>
		<td>${u.memo}</td>
		<td>${u.expirationdate}</td>
		<td><a href="javascript:complete_ok('${u.id}')">재료 소진</a>${u.comp}</td>
		<td>${u.inventory}</td>
		<td>${u.price}</td>
		<td><button type = "button" onclick="location.href='editform/${u.id}'" >Edit</button></td>
		<td><a href="javascript:delete_ok('${u.id}')">Delete</a></td>
	</tr>
</c:forEach>
</table>
<br/><button type = "button"  onclick="location.href='add'">Add New Post</button>
</body>
</html>
