<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
<link rel="stylesheet" href="upload.css">
</head>
<body>
    <h3>차트 생성을 시작할까요?</h3>
    <h4>파일을 업로드하세요.</h4>
    <form method="post" action="UploadServlet" enctype="multipart/form-data">
        <input type="file" name="multiPartServlet" multiple="multiple"/>
        <input type="submit" value="Upload"/>
    </form>
</body>
</html>	