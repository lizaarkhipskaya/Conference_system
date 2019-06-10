<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setBundle basename="page_content"/>
<fmt:setLocale value="${locale}" scope="session" />

<div class="col-md-6">
    <form class="form" action="/app/add_speech" method="post">
        <h1>Добавить речь</h1>
        <div class="col-md-12">
            <div class="form-group">
            <p>Введите название речи(до 100 символов) </p>
                <input type="text" class="form-control" name="theme" placeholder="Название речи"/>
            </div>
        </div>
        <div class="col-md-12">
            <div class="form-group">
                <label for="exampleFormControlSelect1">Выберите конференцию</label>
                <select class="form-control" name="id" id="exampleFormControlSelect1">
                <c:forEach var="confInfo" items="${conferenceDtoList}">
                    <option value="${confInfo.id}" id="exampleFormControlSelect1"><h5><c:out value="${confInfo.theme}"/><c:out value="${confInfo.date}"/></p></h5></option>
                </c:forEach>
                </select>
            </div>
        </div>
        <button class="btn btn-outline-secondary btn-lg" type="submit">Отправить</button>
        <h4><p class="text-success">${successfullyCompletedAdd}</p></h4>
        <h4><p class="text-danger ">${incorrectSpeechRegister}<h4><p class="text-danger">
    </form>
</div>
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