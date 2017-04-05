<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<form action="login" method="post">
	<table>
		<caption><h3>User Login</h3></caption>
		<tr>
			<td>Username:<input type="text" name = "userName"/></td>
		</tr>
		<tr>
			<td>Password:<input type="password" name = "userPassword"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="Login"/></td>
		</tr>
	</table>
	</form>
</body>
</html>