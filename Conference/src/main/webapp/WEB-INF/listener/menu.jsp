<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setBundle basename="page_content"/>
<fmt:setLocale value="${locale}" scope="session" />
<div class="col-md-3">
                <nav class="sidebar-sticky  navbar navbar-expand-md">
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto flex-column text-center">
                            <li class="nav-item active">
                                <a href="/app/main_page" class="nav-link"><fmt:message key="user.menu.personal_account"/></a>
                            </li>
                            <li class="nav-item active">
                                <a href="/app/today_conferences" class="nav-link"><fmt:message key="user.menu.today_conferences"/></a>
                            </li>
                            <li class="nav-item">
                                <a href="/app/up_coming_conferences" class="nav-link"><fmt:message key="user.menu.up_coming_conferences"/></a>
                            </li>
                            <li class="nav-item">
                                <a href="/app/past_conferences" class="nav-link"><fmt:message key="user.menu.past_conferences"/></a>
                            </li>
                            <li class="nav-item">
                                <a href="/app/speaker_list" class="nav-link"><fmt:message key="user.menu.speaker_rating"/></a>
                            </li>
                        </ul>
                    </div>
                </nav>
</div>