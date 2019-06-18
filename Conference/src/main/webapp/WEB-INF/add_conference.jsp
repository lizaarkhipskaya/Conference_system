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
        <div class="maincontainer">+
            <c:import url="/WEB-INF/component/header.jsp" charEncoding="utf-8" />
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
                <form class="form" action="/app/add_conference" method="post" style="font-size: 1rem;">
                <h1><fmt:message key="user.content.header.new_conference"/></h1>
                        <div class="col-md-6">
                            <div class="form-group">
                            <label for="theme"><fmt:message key="user.moderator.content.label_theme"/></label>
                                <input type="text" class="form-control" id="theme"  name="theme" placeholder="<fmt:message key='user.moderator.placeholder.theme'/>"/>
                            ${invalidTheme}
                            </div>
                        </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                     <label for="datetimepicker2"><fmt:message key="user.moderator.content.label_date"/></label>
                                        <div class="input-group date" id="datetimepicker2" data-target-input="nearest">
                                            <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker2" name="date"/>
                                            <div class="input-group-append" data-target="#datetimepicker2" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <script type="text/javascript">
                                    $(function () {
                                        $('#datetimepicker2').datetimepicker({
                                            locale: ${locale}
                                        });
                                    });
                                </script>
                                <p class="text-danger">${invalidDate}</p>
                        <div class="text-center col-md-6">
                        <div class="form-group">
                              <input type="submit"  value="<fmt:message key='button.submit'/>" />
                              <p class="text-danger">${reregistrationConference}</p>
                        </div>
                        </div>

                </form>
            </main>
        </div>
    </div>
            <script type="text/javascript">
                $(function () {
                    $('#datetimepicker1').datetimepicker();
                });
            </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
        </head>
</body>
</html>