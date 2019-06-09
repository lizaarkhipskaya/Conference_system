<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setBundle basename="page_content"/>
<fmt:setLocale value="${locale}" scope="session" />
<div class="col-md-3">
                <nav class="sidebar-sticky  navbar navbar-expand-md">
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto flex-column text-center">
                            <li class="nav-item">
                                <a href="/app/week_conferences" class="nav-link">Конференции на этой неделе</a>
                            </li>
                            <li class="nav-item">
                                <a href="/app/add_conference" class="nav-link">Добавить новую конференцию</a>
                            </li>
                            <li class="nav-item active">
                                <a href="/app/past_conferences" class="nav-link">Прошедшие конференции</a>
                            </li>
                            <li class="nav-item active">
                                <a href="/app/up_coming_conferences" class="nav-link">Предстоящие конференции</a>
                            </li>
                            <li class="nav-item">
                                <a href="/app/speaker_list" class="nav-link">Спикеры</a>
                            </li>
                        </ul>
                    </div>
                </nav>
</div>