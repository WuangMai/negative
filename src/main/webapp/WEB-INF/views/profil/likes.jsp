<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Preferencje</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>

<form name="likes" method="post" class="column">
    <div class="field">
        <label class="label" for="political">Partia polityczna</label>
        <div class="control">
            <div class="select">
                <select name="political" id="political">
                    <option>Wybierz:</option>
                    <c:forEach items="${political}" var="political">
                        <option>${political.name}</option>
                    </c:forEach>
                </select>
                <button type="submit" class="button is-success">Zapisz</button>
            </div>
        </div>
    </div>
</form>

</body>
</html>