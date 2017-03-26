<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<form action="updatePassword" method="post">
	<table>
		<caption>User Login</caption>
		<tr>
			<td>Username:<input type="password" name = "oldPassword"/></td>
		</tr>
		<tr>
			<td>Password:<input type="password" name = "newPassword"/></td>
		</tr>
		<tr>
			<td>Password:<input type="password" name = "confirmPassword"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="Login"/></td>
		</tr>
	</table>
	</form>
</body>
</html>