<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.team16.foodapp.food.FoodDAO, com.team16.foodapp.food.FoodVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	FoodDAO foodDAO = new FoodDAO();
	String id=request.getParameter("id");	
	FoodVO u=foodDAO.getFood(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editok" method="post">
<input type="hidden" name="seq" value="<%=u.getId() %>"/>
<table>
<tr><td>Food:</td><td><input type="text" name="name" value="<%= u.getName()%>"/></td></tr>
<tr><td>Memo:</td><td><input type="text" name="memo" value="<%= u.getMemo()%>" /></td></tr>
<tr><td>Date:</td><td><input type="text" name="expirationdate" value="<%= u.getExpirationdate()%>" /></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>