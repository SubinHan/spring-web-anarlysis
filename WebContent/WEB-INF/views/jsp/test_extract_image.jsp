
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*,java.io.*,kr.ac.jbnu.se.awp.gitplay4.core.FileManager"%>
<%@ page import="java.sql.*"%>

<%
	String fullpath = FileManager.getRecentChartFile((String)session.getAttribute("id")).getPath();
%>

<title>Insert title here</title>
</head>
<body>
	 <img src="images" width=512 height=384></img>
	 
	<!--  <img src="<spring:url value='/image/Untitled.png'/>"/> -->
	<a href src="<%=fullpath%>" download>Download!!</a>

	 
	<form action="download/<%=session.getAttribute("id")%>" method="get">
		<input type ="submit" ></input>
	</form>

</body>
</html>