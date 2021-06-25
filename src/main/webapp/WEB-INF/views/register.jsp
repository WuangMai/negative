<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rejestracja</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>

<form:form method="post" modelAttribute="user" cssClass="column">
    <div class="field">
        <label class="label">Nazwa</label>
        <div class="control has-icons-left">
            <form:input path="name" cssClass="input" type="text" placeholder="Jak chcesz się nazywać"/>
            <span class="icon is-small is-left">
            <i class="fas fa-user"></i>
        </span>
        </div>
    </div>
    <div class="field">
        <label class="label">Email</label>
        <div class="control has-icons-left">
            <form:input path="email" cssClass="input" type="text" placeholder="Adres email"/>
            <span class="icon is-small is-left">
            <i class="fas fa-envelope-open"></i>
        </span>
        </div>
    </div>
    <div class="field">
        <label class="label">Hasło</label>
        <div class="control has-icons-left">
            <form:input path="password" cssClass="input" type="password" placeholder="Hasło"/>
            <span class="icon is-small is-left">
            <i class="fas fa-lock"></i>
        </span>
        </div>
    </div>
    <div class="field">
        <p class="control">
            <form:button name="register" id="register" type="submit"
                         cssClass="button is-success">Zarejestruj!</form:button>  <%-- nie działa stylowanie :( --%>
        </p>
    </div>
</form:form>

</body>
</html>
