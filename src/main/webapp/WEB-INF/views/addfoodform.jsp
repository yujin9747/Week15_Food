<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addform page</title>
</head>
<body>

<h1>식재료 추가하기</h1>
<form action="addok" method="post">
<table id="edit">
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
<tr><td>Memo:</td><td><input type="text" name="memo"/></td></tr>
<tr><td>Date:</td><td><input type="text" name="expirationdate"/> 2021/01/31 형태로 입력하세요</td></tr>
<tr><td>Inventory:</td><td><input type="text" name="inventory"/></td></tr>
<tr><td>Price:</td><td><input type="text" name="price"/></td></tr>
<tr><td><button type = "button" onclick="location.href='list'">식재료 목록 보기</button></td>
<td align="right"><button type="submit">등록하기</button></td></tr>
</table>
</form>
</body>
</html>
