
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

<fmt:setLocale value="ru_RU" />
<fmt:setBundle basename="page_content"/>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>Mintos - SHARED ON THEMELOCK.COM  I Developer-friendly Admin Dashboard UI framework</title>
    <meta name="description" content="A responsive bootstrap 4 admin dashboard template by hencework" />

    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="icon" href="favicon.ico" type="image/x-icon">


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>

    <body data-spy="scroll" data-target=".navbar" data-offset="60">
            <c:import url="\header.jsp" charEncoding="utf-8" />
            <div class="container">
                <div class="myForm bg-light">

                                  <h3 class="text-center">Glad to see u again!</h3>
                                      <form class="form" action="/guest/sign_in">

                                          <div class="col-md-12">
                                               <div class="form-group">
                                                    <input type="email" name="email" class="form-control" placeholder="Ваш E-mail" />
                                               </div>
                                           </div>
                                           <div class="col-md-12">
                                               <div class="form-group">
                                                   <input type="password" name="password" class="form-control" value="samplepass" />
                                                </div>
                                           </div>

                                           <div class="text-center col-md-12">
                                               <input type="submit"  value="Submit" />

                                           </div>
                                       </form>
                                       <form action="/guest/map?source=signup">
                                           <input type="submit" class="btn btn-default" value="Sign In"   />
                                       </form>

        </div>
        </div>

    </body>
</html>