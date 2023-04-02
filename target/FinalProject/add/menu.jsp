<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">

      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="<%= AppConstant.START_NEWS_CONT_URL %>" />">Главная</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="<%= AppConstant.O_NAS_JSP %>" />">О нас</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Контакты</a>
        </li>
      </ul>

      <c:choose>
        <c:when test="${user == null}">
          <ul class="navbar-nav me-2 mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="<c:url value="<%= AppConstant.AUTH_JSP %>" />">Авторизация</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<c:url value="<%= AppConstant.REG_JSP %>" />">Регистрация</a>
            </li>
          </ul>
        </c:when>
        <c:otherwise>
          <ul class="navbar-nav me-2 mb-2 mb-lg-0">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Кабинет
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="<c:url value="<%= AppConstant.CABINET_JSP %>"/>">Кабинет</a></li>
                <li><a class="dropdown-item" href="<c:url value="<%= AppConstant.ADD_NEWS_JSP %>" />">Добавить новость</a></li>
                <li><a class="dropdown-item" href="<c:url value="<%= AppConstant.USER_LIST_NEWS_CONT_URL %>"/> ">Мои новости</a></li>
              </ul>
            </li>

            <li class="nav-item">
              <a class="nav-link" href="<c:url value="<%= AppConstant.LOGOUT_CONT_URL %>"/>">Выход</a>
            </li>
          </ul>
        </c:otherwise>
      </c:choose>

    </div>
  </div>
</nav>