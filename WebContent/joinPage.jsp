<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="joinOk.jsp" method="post">
	
	<table width="400" align="center" border="1">
		<tr><th colsapn="2">회원가입</th></tr>
		<tr>
			<td width ="200" align="center">아이디</td>
			<td width ="200" align="center"><input type="text" name="id"/></td>
		</tr>
		<tr>
			<td width ="200" align="center">비밀번호</td>
			<td width ="200" align="center"><input type="text" name="password"/></td>
		</tr>
		<tr>
			<td colspan ="2" align="center"><input type="submit" value="회원가입하기"/></td>
		</tr>
	</table>
	</form>
</body>
</html>