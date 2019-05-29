
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<fmt:setLocale value="en_US" scope="session" />
<fmt:setBundle basename="page_content" var="pc" />
<html>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title></title>
    <meta name="description" content="" />

    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css">

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="60">
    <header class="header">
        <div class="maincontainer">
            <c:import url="/WEB-INF/header.jsp" charEncoding="utf-8" />
        </div>
    </header>
    <div class="about">
        <div class="row">
            <c:import url="/WEB-INF/${role}/menu.jsp" charEncoding="utf-8" />
            <main class="col-md-9">
            <div class="row">
                <div class="container">
                    <c:forEach var="speaker" items="${speakerList}">
                    <div class="row">
                        <div class="col-md-4">
                            ${speaker.name} ${speaker.surname}
                        </div>
                        <div class="col-md-2">
                            ${speaker.reating}
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
            </main>
        </div>
    </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>