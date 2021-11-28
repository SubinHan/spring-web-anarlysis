<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="javax.servlet.http.HttpServletRequest, java.io.File, kr.ac.jbnu.se.awp.gitplay4.core.*"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dynamic form</title>
<link rel="stylesheet" href="css/register.css">
</head>
<%


File csvFile = FileManager.getRecentCsv((String)session.getAttribute("id"));
CsvAnalyzer analyzer = new CsvAnalyzer(csvFile.getPath(), true);

String[] givenColName;
givenColName = analyzer.getColumnNames();
int givenColNum;
%>
<body>
	<h1>설정</h1>
	<div>
		<form method="post" action="DynamicFormExServlet">
			<fieldset>
				<legend>차트 이름 설정</legend>
				<input type="text" name="chartName">
			</fieldset>
			<fieldset>
				<legend>축 설정</legend>
				<ul>
					<li><label for=xaxis>x축</label> <select name="xAxis">
							<%
							for (String name : givenColName) {
							%>
							<option><%=name%>
							</option>
							<%
							}
							%>
					</select></li>
					<li><label for=yaxis>y축</label> <select name="yAxis">
							<%
							for (String name : givenColName) {
							%>
							<option><%=name%>
							</option>
							<%
							}
							%>
					</select></li>
				</ul>
			</fieldset>
			<fieldset>
				<legend>범위 설정</legend>
				<input type="text" name="ymin"> ~ <input type="text"
					name="ymax">
			</fieldset>		
			<input type="submit" value="Confirm">
		</form>
	</div>
</body>
</html>