
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*,java.io.*,kr.ac.jbnu.se.awp.gitplay4.core.CsvManager"%>
<%@ page import="java.sql.*"%>

<%
	String fullpath = CsvManager.getRecentChartFile(CsvManager.getUserIP(request)).getPath();
%>

<title>Insert title here</title>
</head>
<body>
	<img src="<%=fullpath%>" width=512 height=384></img>
</body>
</html>