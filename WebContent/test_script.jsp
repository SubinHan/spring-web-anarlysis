<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script langnuage="JavaScript">
        function addDiv(){
        	var container = document.getElementById('container');
        	var form = document.createElement('form');
        	var input=document.createElement('input');
        	input.type='text';
        	input.name='myInput';
        	input.value='Values of my Input';
        	form.appendChild(input);
        	container.appendChild(form);
        }
    </script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginS" method="post">  
    <button type="button" onclick="addDiv();">Generate</button>
    <div id="container">
    </div>
  
</form>
</body>
</html>