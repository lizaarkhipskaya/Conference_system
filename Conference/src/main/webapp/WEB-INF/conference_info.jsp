<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setBundle basename="page_content"/>
<fmt:setLocale value="${locale}" scope="session" />


<!DOCTYPE html>

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
            <c:if test="${empty user}">
                <c:redirect url="/index.jsp"/>
            </c:if>
            <c:if test="${not empty user}">
                <c:import url="/WEB-INF/${role}/menu.jsp" charEncoding="utf-8" />
            </c:if>
            <main class="col-md-9">
                <h1><c:out value="${conference.theme}"/></h1>
                <p><c:out value="${conference.date}"/></p>
                <div class="row">
                    <c:forEach var="speech" items="${conference.speeches}">
                        <div class="col-md-6">
                            <h2><c:out value="${speech.theme}"/></h2>
                            <p><c:out value="${speech.speaker.name} ${speech.speaker.surname}"/></p>
                            <p><c:out value=""/></p>
                        </div>
                        <c:if test="${role}==moderator">
                        <div class="col-md-6">
                            <button class="btn primary">Редактировать тему</button>
                            <button class="btn primary">Предложить новую</button>
                            <button class="btn primary">edit</button>
                        </div>
                        </c:if>
                    </c:forEach>
                </div>
                <c:if test="${not empty reregistration}">
                    <h3 text="danger" >${reregistration}</h3>
                </c:if>
                <c:if test="${empty reregistration}">
                <a href="#"  id="bd" data-toggle="modal" data-target="#exampleModal">Зарегистрироваться</a>
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModal" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel">Подтверждение регистрации</h5>
                        </div>
                        <div class="modal-body">
                        <c:if test="${empty reregistration}">
                          <a href="/app/registration_on_conference?id=${conference.id}"><button class="btn primary">Зарегистрироваться</button></a>
                          <!--<button class="close" type="button" data-dismiss="modal" aria-label="close">Отмена</button>-->
                        </c:if>
                        <c:if test="${not empty reregistration}">
                          <h3 text="danger" >${reregistration}</h3>
                        </c:if>
                        </div>
                      </div>
                    </div>
                </div>
                </c:if>
            </main>
        </div>
    </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>