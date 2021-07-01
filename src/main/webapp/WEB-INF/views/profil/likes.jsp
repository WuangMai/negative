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

<form:form modelAttribute="like" method="post">
    <form:select path="name" items="${allLikes}" itemLabel="name" itemValue="name"/>
    <form:hidden path="id"/>
    <form:hidden path="category" value="political"/>


    <form:button type="submit">Zapisz</form:button>
</form:form>

</body>
</html>
