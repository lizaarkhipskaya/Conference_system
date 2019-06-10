<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:setBundle basename="page_content"/>
<fmt:setLocale value="${locale}" scope="session" />

<header class="header">
    <nav class="navbar navbar-expand-lg fixed-top ">
        <a class="navbar-brand" href="/"><fmt:message key="header.link.home"/></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="navbar-nav mr-4">
                <li class="nav-item">
                    <a class="nav-link" data-value="about" href="/app/map?source=about"><fmt:message key="header.link.about"/></a>
                </li>
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${sessionScope.locale=='en'}">
                            <a class="nav-link" data-value="about" href="/app/change_language?locale=ru_RU"><fmt:message key="header.link.language"/></a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" data-value="about" href="/app/change_language?locale=en"><fmt:message key="header.link.language"/></a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <c:choose>
                    <c:when test="${empty user}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><fmt:message key="header.link.sign_in"/></a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="/app/map?source=sign_up"><fmt:message key="header.link.sign_up"/></a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="/app/map?source=sign_in"><fmt:message key="header.link.sign_in"/></a>
                                </div>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link " data-value="team" href="/app/sign_out"><fmt:message key="header.link.sign_out"/></a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
</header>