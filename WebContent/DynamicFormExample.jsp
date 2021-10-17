<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String[] givenColName = { "Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6", "Column 7" };
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
		<%
		for (int i = 0; i < givenColNum; i++) {
		%>
		<input type="checkbox" name="yAxis" value="<%="item" + (i+1)%>"><%=givenColName[i]%>
		<%
		}
		%>
		<br> <input type="submit" value="Confirm">

	</form>
</body>
</html>