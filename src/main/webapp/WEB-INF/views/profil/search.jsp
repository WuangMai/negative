<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wyszukiwanie pojedynku</title>
</head>
<body>

<div>W jakiej kategorii chcesz szukać pojedynku?</div>
<form method="post" action="/profil/search">
    <select name="category" id="category">
        <option value="">Wybierz:</option>

        <option value="political">Polityka</option>
        <option value="earth shape">Kształt Ziemi</option>
        <option value="vaccines">Podejście do szczepień</option>

    </select>
    <input type="submit" value="Szukaj">
</form>

<div> nazwa przeciwnika: ${opponent.name}</div>

</body>
</html>