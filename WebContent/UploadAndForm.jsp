<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var asyncRequest;
	function uploadFile() {
 		 var data = new FormData();
 		data.append('multiPartServlet', document.getElementById("multiPartServlet").files[0]);
		
		var xhr = new XMLHttpRequest();
		xhr.open('POST', 'UploadServlet', true);
		xhr.onreadystatechange = function () {
		    // do something to response
		    uploadFinished();
		};
		xhr.send(data);  

	}
	
	function uploadFinished(){
		alert('upload Finished!');
	}
</script>

</head>
<body>
	<h3>서블릿3부터 지원하는 Part 인터페이스를 이용한 파일업로드</h3>
	<form
		enctype="multipart/form-data" id="form" onsubmit="uploadFile();">
		파일선택: <input type="file" id="multiPartServlet" multiple="multiple" />
		<input type="submit"			value="Upload" />
	</form>
</body>
</html>