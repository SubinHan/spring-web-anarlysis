<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>select_chart</title>
<link rel="stylesheet" href="css/select.css">

</head>
<body>
	<div id="image">
		<img src="images/anarlysis.jpg" height=50px; width=auto;>
	</div>

	<div id="container">

		<div id="title">� ��Ʈ�� �ʿ��ϼ���?</div>

		<div id="subtitle">���Ͻô� ��Ʈ�� �������ּ���.</div>

		<div class="flex_container">
			
			<div class="item">
				<div class="bar_chart">
					<form action="SelectServlet" method="post">
						<input type="button" class="bar_img" name="chatType" value="BAR">
					</form>
				</div>
			</div>

			<div class="histogram">
				<form action="SelectServlet" method="post">
					<input type="submit" class="his_img"> <input type="hidden"
						name="chartType" value="HISTOGRAM" />
				</form>
			</div>

			<div class="boxpolt">
				<form action="SelectServlet" method="post">
					<input type="submit" class="box_img"> <input type="hidden"
						name="chartType" value="BOX" />
				</form>
			</div>

			<div class="linechart">
				<form action="SelectServlet" method="post">
					<input type="submit" class="line_img"> <input type="hidden"
						name="chartType" value="LINE" />
				</form>
			</div>

		</div>



	</div>
</body>
</html>