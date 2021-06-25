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
<form method="post" action="/login" class="column">
    <div class="field">
        <label class="label" for="email">Email</label>
        <div class="control has-icons-left">
            <%--            <form:input path="name" cssClass="input" type="text" placeholder="Jak chcesz się nazywać"/>--%>
            <input name="username" id="email" type="email" class="input"/>
            <span class="icon is-small is-left">
            <i class="fas fa-envelope-open"></i>
        </span>
        </div>
    </div>
    <div class="field">
        <label class="label" for="password">Hasło</label>
        <div class="control has-icons-left">
            <%--            <form:input path="password" cssClass="input" type="password" placeholder="Hasło"/>--%>
            <input name="password" id="password" type="password" class="input"/>
            <span class="icon is-small is-left">
            <i class="fas fa-lock"></i>
        </span>
        </div>
    </div>
    <div class="field">
        <p class="control">
            <button type="submit" class="button is-success" name="login" id="login">Zaloguj!</button>
        </p>
    </div>
</form>
</body>
</html>