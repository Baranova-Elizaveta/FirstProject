<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page import="by.itclass.model.utils.DateUtil" %>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>My news:: ${user.login}</title>
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
			<h2>Мои новости</h2>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="main_news">

				<table class="table table-bordered">
					<tr>
						<th>ID</th>
						<th>Заголовок</th>
						<th>Текст</th>
						<th>Img</th>
						<th>Дата</th>
						<th>действие</th>
					</tr>

					<c:forEach items="${newsList}" var="news">
						<tr>
							<td>${news.id}</td>
							<td>${news.title}</td>
							<td>${news.text}</td>
							<td><img src="image/img1.jpg" width="100px"></td>
							<td>${DateUtil.format(news.date, DateUtil.DD_MM_YYYY)}</td>
							<td>
								<a href="<c:url value="<%= AppConstant.GET_NEWS_CONT_URL %>"/>?action=edit&id=${news.id}" class="btn btn-warning">Редактировать</a><br><br>
								<a href="<c:url value="<%= AppConstant.DELETE_NEWS_CONT_URL %>"/>?id=${news.id}" class="btn btn-danger">Удалить</a><br>
							</td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
	</div>

</div>

<c:import url="add/footer.jsp"/>

<script src="js/bootstrap.js"></script>
<script src="js/jquery-3.6.0.js"></script>
</body>
</html>