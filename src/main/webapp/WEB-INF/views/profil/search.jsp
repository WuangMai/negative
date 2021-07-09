<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wyszukiwanie pojedynku</title>
</head>
<body>


<div> Znaleziony przeciwnik: ${opponent.name} </div>
<form method="post">

    <select name="competition" id="competition">
        <option value="" >Dziedzina</option>
        <c:forEach items="${competitionList}" var="cmptList">
            <option value="${cmptList.id}">${cmptList.competition}</option>
        </c:forEach>
    </select>
    <input type="text" name="oppName" value="${opponent.name}" hidden>

    <input type="submit" value="Pojedynek">
</form>


</body>
</html>