<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Registration</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-grid.css">
	<link rel="stylesheet" href="css/bootstrap-reboot.css">
	<link rel="stylesheet" href="css/bootstrap-utilities.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<c:import url="add/menu.jsp"/>

	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>	
			<div class="col-md-4 m_corr text_center">
				<h2>Регистрация</h2>
				<br>
				<c:import url="add/message.jsp"/>
				<form method="post" action="<c:url value="<%= AppConstant.REGISTRATION_CONT_URL %>"/>">
					<input type="text" name="<%= AppConstant.LOGIN_LABEL %>" class="form-control" placeholder="Введите имя"><br>
					<input type="password" name="<%= AppConstant.PASSWORD_LABEL %>" class="form-control" placeholder="Введите пароль"><br>
					<input type="password" class="form-control" placeholder="Введите подтверждение пароля"><br>
					<input type="email" name="<%= AppConstant.EMAIL_LABEL %>" class="form-control" placeholder="Введите почту"><br>
					<input type="submit" class="btn btn-success" value="Регистрация">
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>

	<script src="js/bootstrap.js"></script>
	<script src="js/jquery-3.6.0.js"></script>
</body>
</html>