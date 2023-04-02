<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Cabinet::${user.login}</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-grid.css">
	<link rel="stylesheet" href="css/bootstrap-reboot.css">
	<link rel="stylesheet" href="css/bootstrap-utilities.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<c:import url="add/menu.jsp"/>

	<div class="container" style="height: 1000px;">
		<div class="row">
			<div class="col-md-12 m_corr">
				<h2>Добро пожаловать ${user.login}</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="main_news">
					<div class="row">
						<div class="col-3">
							<img src="image/${user.image.name}" class="img-fluid">
<%--							<c:choose>--%>
<%--								<c:when test="${user.image.name != null}">--%>
<%--									--%>
<%--								</c:when>--%>
<%--								<c:otherwise>--%>
<%--									<img src="image/user.png" class="img-fluid">--%>
<%--								</c:otherwise>--%>
<%--							</c:choose>--%>
							<form method="post" action="<c:url value="<%= AppConstant.UPLOAD_IMAGE_CABINET_CONT_URL %>" />" enctype="multipart/form-data">
								<input type="file" name="image" class="form-control">
								<input type="submit" class="btn btn-success" value="Загрузить">
							</form>
						</div>
						<div class="col-9">
							<h3>Личные данные</h3><hr>
							<p>Текущая почта: ${user.email}</p>
							<form method="post" action="<c:url value="<%= AppConstant.UPDATE_CABINET_CONT_URL %>"/> ">
								<input type="text" class="form-control" name="<%= AppConstant.LOGIN_LABEL%>" value="${user.login}" placeholder="Имя"><br>
								<input type="email" class="form-control" name="<%= AppConstant.EMAIL_LABEL %>" value="${user.email}" placeholder="Почта"><br>
								<input type="password" class="form-control" name="<%= AppConstant.PASSWORD_LABEL %>" placeholder="Новый пароль"><br>
								<input type="password" class="form-control" placeholder="Подтвердить новый пароль"><br>
								<input type="submit" class="btn btn-success" value="Поменять">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/bootstrap.js"></script>
	<script src="js/jquery-3.6.0.js"></script>
</body>
</html>