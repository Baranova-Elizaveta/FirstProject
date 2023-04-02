<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Add News</title>
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
				<h2>Добавить новость</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="main_news">
					<form method="post" action="<c:url value="<%= AppConstant.SAVE_NEWS_CONT_URL %>"/>">
						<input type="text" name="<%= AppConstant.TITLE_LABEL %>" class="form-control" placeholder="Введите заголовок"><br>
						<textarea rows="10" name="<%= AppConstant.TEXT_LABEL %>" class="form-control" placeholder="Введите текст новости"></textarea><br>
						<input type="file" class="form-control"><br>
						<input type="submit" class="btn btn-success" value="Добавить новость">
					</form>
				</div>
			</div>
		</div>

	</div>

	<c:import url="add/footer.jsp"/>

	<script src="js/bootstrap.js"></script>
	<script src="js/jquery-3.6.0.js"></script>
</body>
</html>