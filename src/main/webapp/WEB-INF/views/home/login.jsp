<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logowanie</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<div class="hero is-fluid">
    <div class="notification is-primary">
        <h1 class="title is-1"><strong>LOGOWANIE</strong></h1>
    </div>
</div>
<br/>

<div class="container">
    <div class="columns is-centered">
        <div class="column is-6-tablet is-5-desktop is-4-widescreen">
            <form method="post" action="/login" class="box">
                <div class="field">
                    <label class="label" for="email">Email</label>
                    <div class="control has-icons-left">
                        <input name="username" id="email" type="email" class="input"/>
                        <span class="icon is-small is-left">
            <i class="fas fa-envelope-open"></i>
        </span>
                    </div>
                </div>
                <div class="field">
                    <label class="label" for="password">Hasło</label>
                    <div class="control has-icons-left">
                        <input name="password" id="password" type="password" class="input"/>
                        <span class="icon is-small is-left">
            <i class="fas fa-lock"></i>
        </span>
                    </div>
                </div>


                <div class="field">
                    <div class="field is-grouped">
                        <p class="control">
                            <button type="submit" class="button is-success is-" name="login" id="login">Zaloguj!</button>
                            <a href="/register" class="button is-warning">Rejestracja</a>
                        </p>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>