<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.team16.foodapp.food.FoodDAO, com.team16.foodapp.food.FoodVO"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<h1>Edit Form</h1>
<form:form commandName = "foodVO" action="../editok" method="post">
<form:hidden path="id"/>
<table id="edit">
<tr><td>Food:</td><td><form:input path="name"/></td></tr>
<tr><td>Memo:</td><td><form:input path="memo" /></td></tr>
<tr><td>Date:</td><td><form:input path="expirationdate" /></td></tr>
<tr><td>Inventory:</td><td><form:input path="inventory" /></td></tr>
<tr><td>Price:</td><td><form:input path="price" /></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form:form>

</body>
</html>
