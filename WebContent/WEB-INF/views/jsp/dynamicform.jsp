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
<link rel="stylesheet" href="css/login.css">
</head>
<%
File csvFile = FileManager.getRecentCsv((String) session.getAttribute("id"));
CsvAnalyzer analyzer = new CsvAnalyzer(csvFile.getPath(), true);

String[] givenColName;
givenColName = analyzer.getColumnNames();
int givenColNum;
%>
<body>
	<div id="image">
		<img src="images/anarlysis.jpg" height=50px; width=auto;>
	</div>
	<div id = "container">
		<div id = "title">어떤 차트가 필요하세요?</div>
		<div id = "subtitle">차트 생성을 위해 필요한 옵션을 입력해주세요.</div>
		
		<div id = "form">
			<form method="post" action="DynamicFormExServlet">
			<div id = "chartNameForm">
				<input type = "text" name="chartName" class="id" placeholder="차트 이름">
			</div>
			<div id = "axisForm">
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
			</div>
			<div id = "rangeForm">
				<input type="text" name="ymin" class=id placeholder="최솟값" > ~ 
				<input type="text"name="ymax" class=id placeholder="최댓값">
			</div>
			<div id="submitbox">
				<input type="submit" id="submit_button" value="Confirm" />
			</div>
		</form>
		</div>
	</div>
</body>
</html>