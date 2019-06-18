<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setBundle basename="page_content"/>
<fmt:setLocale value="${locale}" scope="session" />

<div class="col-md-6">
    <form class="form" action="/app/add_speech" method="post">
        <h1><fmt:message key="user.profile.header.add_speech"/></h1>
        <div class="col-md-12">
            <div class="form-group">
            <p><fmt:message key="user.speaker.profile.content.input_theme"/></p>
                <input type="text" class="form-control" name="theme" placeholder="<fmt:message key='user.speaker.profile.placeholder.input_theme'/>"/>
            </div>
        </div>
        <div class="col-md-12">
            <div class="form-group">
                <label for="exampleFormControlSelect1"><fmt:message key="user.speaker.profile.content.choose"/></label>
                <select class="form-control" name="id" id="exampleFormControlSelect1">
                <c:forEach var="confInfo" items="${conferenceDtoList}">
                    <option value="${confInfo.id}" id="exampleFormControlSelect1"><h5><c:out value="${confInfo.theme}"/><c:out value="${confInfo.date}"/></p></h5></option>
                </c:forEach>
                </select>
            </div>
        </div>
        <button class="btn btn-outline-secondary btn-lg" type="submit"><fmt:message key="button.submit"/></button>
        <h4><p class="text-success">${successfullyCompletedAdd}</p></h4>
        <h4><p class="text-danger ">${incorrectSpeechRegister}<h4><p class="text-danger">
    </form>
</div>
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