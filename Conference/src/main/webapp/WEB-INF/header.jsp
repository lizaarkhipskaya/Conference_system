<header class="header">
    <nav class="navbar navbar-expand-lg fixed-top ">
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="navbar-nav mr-4">
                <li class="nav-item">
                    <a class="nav-link" data-value="about" href="#">About</a>
                </li>
                <li class="nav-item">
                    <c:choose>
                        <c:when ${locale}="en_US">
                            <a class="nav-link" data-value="about" href="/app/change_language?locale=ru">Русский</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" data-value="about" href="/app/change_language?locale=en">English</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                    <c:if test="${empty user}">
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="/app/map?source=signup">Sign up</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/app/map?source=signin">Sign in</a>
                        </div>
                    </c:if>
                    <c:if test="${not empty user}">
                        <a class="nav-link " data-value="team" href="#">Log out</a>
                    </c:if>
                  </li>
            </ul>
        </div>
    </nav>
</header>