<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profil</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
    <script> function dropdown() {
        document.getElementById("dropdown").classList.toggle("is-active");
    }</script>
</head>
<body>
<div class="hero is-fluid">
    <div class="notification is-primary">
        <h1 class="title is-1"><strong>PROFIL</strong></h1>
    </div>
</div>

<div class="container is-fluid">
    <div class="box">
        <h3 class="title is-3">Witaj ${user.username} !</h3>
    </div>

    <div class="box">
        <div class="columns">
            <div class="column">
                <div class="dropdown" id="dropdown" onclick="dropdown()">
                    <p class="field">
                    <div class="dropdown-trigger field">
                        <button class="button is-danger is-light " aria-haspopup="true" aria-controls="dropdown-menu">
                            <span>Szukaj pojedynku</span>
                            <span class="icon is-small">
        <i class="fas fa-angle-down" aria-hidden="true"></i>
      </span>
                        </button>
                    </div>

                    <div class="dropdown-menu" id="dropdown-menu" role="menu">
                        <div class="dropdown-content">
                            <a href="<c:url value="/search?category=political"/>" class="dropdown-item">
                                Kategoria: Polityka
                            </a>
                            <a href="/search?category=earth%20shape" class="dropdown-item">
                                Kategoria: Kształt ziemi
                            </a>
                            <a href="/search?category=vaccines" class="dropdown-item">
                                Kategoria: Szczepienia
                            </a>
                        </div>
                    </div>
                </div>

                <p class="field">
                    <a href="/profil/#" class="button is-info is-light">Ostatnie pojedynki</a>
                </p>
            </div>
            <div class="column is-4">
                <p class="field">
                    <a href="/profil/likes" class="button is-link">Ustaw preferencje</a>
                </p>
                <p class="field">
                    <a href="<c:url value="/logout" />" class="button is-danger">Wyloguj się</a>
                </p>
            </div>
        </div>
    </div>
</div>

</body>
</html>