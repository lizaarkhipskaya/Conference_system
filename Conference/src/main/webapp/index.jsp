
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="page_content"/>

<!DOCTYPE html>

<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="page_content" var="pc" />
<html>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>Mintos - SHARED ON THEMELOCK.COM  I Developer-friendly Admin Dashboard UI framework</title>
    <meta name="description" content="A responsive bootstrap 4 admin dashboard template by hencework" />

    <link rel="shortcut icon" href="favicon.ico">
    <link rel="icon" href="favicon.ico" type="image/x-icon">


    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="resources/css/style.css" rel="stylesheet" type="text/css">

</head>
    <body data-spy="scroll" data-target=".navbar" data-offset="60">
    <c:import url="\WEB-INF\header.jsp" charEncoding="utf-8" />
    <div class="row">
        <c:if test="${not empty user}">
            <div class="col-md-3">
                <c:import url="/WEB-INF/${role}/menu.jsp" charEncoding="utf-8" />
            </div>
            <div class="col-md-9">
                <div class="maincontainer">
                    <div class="overlay">
                        <div class="container">
                            <div class="description">
                                <h1>    Hello ,Welcome To My official Website
                                <p>    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                </p>
                                <button class="btn btn-outline-secondary btn-lg">See more</button></h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${empty user}">
            <div class="maincontainer">
                <div class="overlay">
                    <div class="container">
                        <div class="description">
                            <h1>    Hello ,Welcome To My official Website
                            <p>    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <button class="btn btn-outline-secondary btn-lg">See more</button></h1>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    <div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

   </body>
</html>