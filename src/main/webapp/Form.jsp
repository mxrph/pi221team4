<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Калькулятор - периметр круга</title>
</head>
	<body>
	<h1>Калькулятор - периметр круга</h1>
	<form action="${pageContext.request.contextPath }/JavaCalc" method="post">
	<label for="radius"> Радиус круга:</label>
	<input type="text" name="radius" id="radius" value="${radius}">
		<input type="submit" name="sign" value="Calculate"> 
	</form>
	</body>
</html>