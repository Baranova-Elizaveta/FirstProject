<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="by.itclass.model.utils.DateUtil" %>
<%@ page import="by.itclass.constants.AppConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>cripta.com</title>
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
			<div class="col-lg-8 m_corr">
				<div class="main_news">
					<img src="image/img1.jpg" class="img-fluid">
					<h2>${newsList.get(0).title}</h2>
					<p>${newsList.get(0).text}
						<br>
						<a href="<c:url value="<%= AppConstant.GET_NEWS_CONT_URL %>"/>?action=view&id=${newsList.get(0).id}">читать далее...</a>
					</p>
					<p> &nbsp;
						<span class="right_date">${DateUtil.format(newsList.get(0).date, DateUtil.DD_MM_YYYY_HH_MM)}</span>
					</p>
				</div>
			</div>
			<div class="col-lg-4 m_corr">
				<iframe frameborder="0" height="131" marginheight="0" marginwidth="0" scrolling="no" src="https://admin.myfin.by/outer/informer/brest/full" width="100%"></iframe>

				<hr>

				<h3>Топ новости за неделю:</h3>
				<!-- сделать вывод 3 лучших новостей за последнюю неделю - JAVA -->

				<c:forEach items="${newsListTop}" var="news">
					<div class="top_news">
						<h4> &#128077; ${news.likes} - ${news.title}</h4>
						<p>${news.text}</p>
						<a href="<c:url value="<%= AppConstant.GET_NEWS_CONT_URL %>"/>?action=view&id=${news.id}">читать далее...</a></p>
					</div>
				</c:forEach>

			</div>
		</div>

		<c:forEach items="${newsList}" var="news" begin="1">
			<div class="row">
				<div class="col-md-12 m_corr">
					<div class="regular_news">
						<div class="row">
							<div class="col-4">
								<img src="image/img1.jpg" class="img-fluid">
							</div>
							<div class="col-8">
								<h4>${news.title}</h4>
								<p>${news.text}
									<br>
									<a href="<c:url value="<%= AppConstant.GET_NEWS_CONT_URL %>"/>?action=view&id=${news.id}">читать далее...</a></p>
								<p> &nbsp;
									<span class="right_date">${DateUtil.format(news.date, DateUtil.DD_MM_YYYY_HH_MM)}</span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<c:import url="add/footer.jsp"/>

	<script src="js/bootstrap.js"></script>
	<script src="js/jquery-3.6.0.js"></script>
</body>
</html>