<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Preferencje</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<section class="columns is-mobile is-centered is-multiline">
    <div class="column is-half"></div>
    <div class="column is-half"></div>
    <div class="column is-half">
        <div class="card card-content is-centered">
            <form method="post" action="/profil/likes">

                <div class="field">
                    <label class="label" for="political">Partia polityczna</label>
                    <div class="select">
                        <p class="control">
                            <select name="political" id="political">
                                <option value="">Wybierz:</option>
                                <c:forEach items="${allPoliticalLikes}" var="political">
                                    <option value="${political.name}">${political.name}</option>
                                </c:forEach>
                            </select>
                        </p>
                    </div>
                </div>

                <div class="field">
                    <label class="label" for="earth">Ziemia jest:</label>
                    <div class="select">
                        <p class="control">
                            <select name="earth" id="earth">
                                <option value="">Wybierz:</option>
                                <c:forEach items="${allEarthShapeLikes}" var="earth">
                                    <option value="${earth.name}">${earth.name}</option>
                                </c:forEach>
                            </select>
                        </p>
                    </div>
                </div>

                <div class="field">
                    <label class="label" for="vaccines">W sprawie szczepionek</label>
                    <div class="select">
                        <p class="control">
                            <select name="vaccines" id="vaccines">
                                <option value="">Wybierz:</option>
                                <c:forEach items="${allVaccinesLikes}" var="vaccines">
                                    <option value="${vaccines.name}">${vaccines.name}</option>
                                </c:forEach>
                            </select>
                        </p>
                    </div>
                </div>

                <div class="field">
                    <div class="field is-grouped ">
                        <p class="control">
                            <input type="submit" value="Zapisz" class="button is-success">
                            <a href="/profil" class="button is-danger">Wróć</a>
                        </p>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>
