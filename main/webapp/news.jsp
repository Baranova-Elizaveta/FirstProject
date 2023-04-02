<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${news.title}</title>
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
        <div class="col-lg-12 m_corr">
            <div class="main_news">

                <center>
                    <img src="image/img1.jpg" class="img-fluid" style="max-height: 400px;">
                </center>
                <br>
                <hr>
                <h2>
                    <button form="likesForm" name="<%=AppConstant.ID_LABEL%>" value="${news.id}" class="like_button">&#128077;</button>
                    ${news.likes}
                    ${news.title}</h2>
                <p>${news.text}
                    <br><br>
                    <a href="<c:url value="<%= AppConstant.START_NEWS_CONT_URL %>"/>">Назад</a>
                </p>
                <p> &nbsp;
                    <span class="right_date">${DateUtil.format(news.date, DateUtil.DD_MM_YYYY_HH_MM)}</span>
                </p>
            </div>
        </div>
    </div>
    <form id="likesForm" method="post" action="<c:url value="<%= AppConstant.LIKE_NEWS_CONT_URL %>"/>">
        <input type="hidden" name="<%= AppConstant.ACTION_LABEL %>" value="view">
    </form>
</div>

<c:import url="add/footer.jsp"/>

<script src="js/bootstrap.js"></script>
<script src="js/jquery-3.6.0.js"></script>
</body>
</html>