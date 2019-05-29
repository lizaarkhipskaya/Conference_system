
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>

<fmt:setLocale value="ru_RU" />
<fmt:setBundle basename="page_content"/>
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
    <c:import url="\header.jsp" charEncoding="utf-8" />
    <div class="container">
        <div class="myForm bg-light">
            <h3 class="text-center">Well Style Blue</h3>
                <form class="form" action="/app/sign_up" method="post" style="font-size: 1rem;">
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="text" class="form-control" value="${correctParameters['name']}" name="name" />
                            <p class="text-danger"><c:out value="${incorrect_name}"/></p>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="text" class="form-control" value="${correctParameters['surname']}" name="surname"  />
                            <p class="text-danger"><c:out value="${incorrect_surname}"/></p>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="email" name="email" value="${correctParameters['email']}" class="form-control"  />
                            <p class="text-danger"><c:out value="${incorrect_email}"/></p>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="password" name="password" class="form-control" value=""  />
                            <p class="text-danger">${incorrect_password}</p>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="password" name="confirm_password" class="form-control" value=""   />
                            <p class="text-danger"><c:out value="${incorrect_confirm_password}"/></p>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-group">
                            <select class="form-control" name="role" id="exampleFormControlSelect1">
                                <option><fmt:message key='login.placeholder.speaker'/></option>
                                <option><fmt:message key='login.placeholder.listener'/></option>
                            </select>
                        </div>
                    </div>
                    <div class="text-center col-md-12">
                        <input type="submit"  value="<fmt:message key='login.placeholder.submit'/>" />
                    </div>
                </form>
            <a  href="${pageContext.request.contextPath}/guest/map?source=signin"><span><fmt:message key='login.label.sign_in'/></span></a>
        </div>
    </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>