<%@ page import="core.entity.Car" %>
<%@ page import="core.entity.Brand" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Added brand</title>
    <link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
<div id="options">
    <a href="/cars" class="btn"> Cars </a> <br>
    <a href="/managers" class="btn"> Managers </a> <br>
    <a href="/deals" class="btn"> Deals </a> <br>
</div>
<div id="content">
    <%Brand brand = (Brand) request.getAttribute("brand");%>
    <h1> Added brand: <%=brand.getName()%></h1>
</div>
</body>
</html>