<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setBundle basename="page_content"/>
<fmt:setLocale value="${locale}" scope="session" />

<div class="col-md-6">
       <h1><fmt:message key="user.profile.personal_info"/></h1>
       <div class="card">
         <div class="card-body">
           <p class="text-secondary"><fmt:message key="user.profile.name"/>: ${user.name}</p>
           <p class="text-secondary"><fmt:message key="user.profile.surname"/>: ${user.surname}</p>
           <p class="text-secondary"><fmt:message key="user.profile.email"/>: ${user.email}</p>
         </div>
       </div>
    </div>

    <div class="col-md-6">
        <h1><fmt:message key="user.profile.news"/></h1>
        <div class="card">
         <div class="card-body">
            <div class="p-3 mb-2 bg-secondary text-white"><fmt:message key="user.profile.news"/></div>
         </div>
       </div>
    </div>