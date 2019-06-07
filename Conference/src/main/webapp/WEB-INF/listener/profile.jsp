<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setBundle basename="page_content"/>
<fmt:setLocale value="${locale}" scope="session" />

<div class="col-md-6">
    <form class="form">
        <h1>Добавить речь</h1>
        <div class="col-md-12">
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Название речи"/>
            </div>
        </div>
        <div class="form-group">
            <label for="exampleFormControlSelect1">Example select</label>
            <select class="form-control" id="exampleFormControlSelect1">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </div>
    </form>
</div>
<div class="col-md-6">
    <h1>Личная информация</h1>
</div>