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

<form method="post" action="/profil/likes">
    <select name="political" id="political">
        <c:forEach items="${allPoliticalLikes}" var="p">
            <option value="${p.name}">${p.name}</option>
        </c:forEach>
    </select>

    <select name="earth" id="earth">
        <c:forEach items="${allEarthShapeLikes}" var="earth">
            <option value="${earth.name}">${earth.name}</option>
        </c:forEach>
    </select>
        <input type="submit" value="Zapisz">

</form>


<%--<div class="field">--%>
<%--    <label class="label" >Partia polityczna</label>--%>
<%--    <div class="control">--%>
<%--        <div class="select">--%>
<%--            <form:form modelAttribute="like" method="post">--%>
<%--                <form:select path="name" items="${allEarthShapeLikes}" itemLabel="name" itemValue="name"/>--%>
<%--                <form:hidden path="id"/>--%>
<%--                <form:hidden path="category" value="political"/>--%>
<%--                <form:button type="submit">Zapisz</form:button>--%>
<%--            </form:form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


</body>
</html>
