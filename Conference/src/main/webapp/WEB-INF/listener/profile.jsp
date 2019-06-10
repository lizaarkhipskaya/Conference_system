<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setBundle basename="page_content"/>
<fmt:setLocale value="${locale}" scope="session" />

    <div class="col-md-6">
       <h1>Личная информация</h1>
       <div class="card">
         <div class="card-body">
           <p class="text-secondary">Ваше имя: ${user.name}</p>
           <p class="text-secondary">Ваша фамилия: ${user.surname}</p>
           <p class="text-secondary">Ваша почта: ${user.email}</p>
         </div>
       </div>
    </div>

    <div class="col-md-6">
        <h1>Новости</h1>
        <div class="card">
         <div class="card-body">
            <div class="p-3 mb-2 bg-secondary text-white">Сдесь будут отображаться новости</div>
         </div>
       </div>
    </div>