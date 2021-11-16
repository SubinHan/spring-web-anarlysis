<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<form action="loginAction.jsp" method="post">
	
	<table width="400" align="center" border="1" cellspacing="0" cellpadding="5"]>
	
		<tr><td colspan ="2" align="center">로그인</td></tr>
		<tr>
			<td width ="200" align="center">아이디</td>
			<td width ="200" align="center"><input type="text" name="userID"/></td>
		</tr>
		<tr>
			<td width ="200" align="center">비밀번호</td>
			<td width ="200" align="center"><input type="text" name="userPassword"/></td>
		</tr>
		<tr>
			<td colspan ="1" align="center"><input type="button" value="회원가입하기" onclick=" location='joinPage.jsp'"/></td>
			
			<td colspan ="1" align="center"><input type="submit" value="로그인하기"/></td>
		</tr>
	</table>
	</form>
	
</body>
</html>