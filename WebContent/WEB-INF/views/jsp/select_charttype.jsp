<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Select chartType</title>
</head>
<body>
<h1>차트를 선택하세요.</h1>
	
	<form action="SelectServlet" method="post" >	
		<input type="submit">
		<input type="hidden" name="chartType" value="BAR" />
	</form>
	<form action="SelectServlet" method="post" >	
		<input type="submit">
		<input type="hidden" name="chartType" value="HISTOGRAM" />
	</form>
	<form action="SelectServlet" method="post" >	
		<input type="submit">
		<input type="hidden" name="chartType" value="PIE" />
	</form>
	<form action="SelectServlet" method="post" >	
		<input type="submit">
		<input type="hidden" name="chartType" value="BOX" />
	</form>
	<form action="SelectServlet" method="post" >	
		<input type="submit">
		<input type="hidden" name="chartType" value="LINE" />
	</form>
</body>
</html>