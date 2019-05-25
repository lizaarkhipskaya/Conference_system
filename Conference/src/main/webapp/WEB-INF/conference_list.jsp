
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<!--
Template Name: Mintos - Responsive Bootstrap 4 Admin Dashboard Template
Author: Hencework
Contact: https://hencework.ticksy.com/
License: You must have a valid license purchased only from themeforest to legally use the template for your project.
-->

<fmt:setLocale value="en_US" scope="session" />
<fmt:setBundle basename="page_content" var="pc" />
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>Mintos - SHARED ON THEMELOCK.COM  I Developer-friendly Admin Dashboard UI framework</title>
    <meta name="description" content="A responsive bootstrap 4 admin dashboard template by hencework" />

    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="icon" href="favicon.ico" type="image/x-icon">

	<!-- Lightgallery CSS -->
    <!--<link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css"> -->

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>

    <body data-spy="scroll" data-target=".navbar" data-offset="60">


            <header class="header">
                <div class="maincontainer">
                   <c:import url="/WEB-INF/header.jsp" charEncoding="utf-8" />
                </div>
            </header>
        <div class="about">
              <div class="row">
              <div class="col-md-2">
                  <nav class="sidebar-sticky  navbar navbar-expand-md">


                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                      <ul class="navbar-nav mr-auto flex-column text-center">
                        <li class="nav-item active">
                          <a href="" class="nav-link">Конференции</a>
                        </li>
                        <li class="nav-item">
                          <a href="" class="nav-link">Проекты</a>
                        </li>
                        <li class="nav-item">
                          <a href="" class="nav-link">Команда</a>
                        </li>
                        <li class="nav-item">
                          <a href="" class="nav-link">Отзывы</a>
                        </li>
                        <li class="nav-item">
                          <a href="" class="nav-link">Контакты</a>
                        </li>
                      </ul>
                    </div>
                  </nav>
                <!-- end header -->
                </div>
                <main class="col-md-9">
                  <div class="card" style="width: 18rem;">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">Название карточки</h5>
                      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                      <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                    </div>
                  </div>
                  <div class="card" style="width: 18rem;">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">Название карточки</h5>
                      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                      <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                    </div>
                  </div>
                  <div class="card" style="width: 18rem;">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">Название карточки</h5>
                      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                      <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
                    </div>
                  </div>
                </main>
                <!-- end main -->
              </div>
            </div>
    </body>
</html>