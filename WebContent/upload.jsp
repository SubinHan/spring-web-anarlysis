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
    <h3>파일업로드</h3>
    <form method="post" action="UploadServlet" enctype="multipart/form-data">
        파일선택: <input type="file" name="multiPartServlet" multiple="multiple"/>
        <input type="submit" value="Upload"/>
    </form>
</body>
</html>	