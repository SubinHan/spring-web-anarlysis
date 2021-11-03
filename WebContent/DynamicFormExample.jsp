<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import = "javax.servlet.http.HttpServletRequest, java.io.File, kr.ac.jbnu.se.awp.gitplay4.core.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	String userIP = request.getHeader("X-FORWARDED-FOR");  
	if (userIP == null) {  
		userIP = request.getRemoteAddr();  
	}
	
	File csvFile = CsvManager.getRecentCsv(userIP);
	CsvAnalyzer analyzer = new CsvAnalyzer(csvFile.getPath(), true);
	
	String[] givenColName = { "Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6", "Column 7" };
	givenColName = analyzer.getColumnNames();
	int givenColNum = 7;
	%>
	<form method="post" action="DynamicFormExServlet">
		<h1>Select X-Axis:</h1>
		<select name="xAxis">
			<%
			for (String name : givenColName) {
			%>
			<option><%=name%>
			</option>
			<%
			}
			%>
		</select>

		<h1>Select Y-Axis:</h1>
		<select name="yAxis">
			<%
			for (String name : givenColName) {
			%>
			<option><%=name%>
			</option>
			<%
			}
			%>
		</select>
		<br> <input type="submit" value="Confirm">

   </form>
</body>
</html>