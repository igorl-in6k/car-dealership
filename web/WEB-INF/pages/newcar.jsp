<%@ page import="core.entity.Brand" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>New Car</title>

    <link href="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header-bar">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">Automobile Dealership</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li><a href="/">Home</a></li>
                    <li><a href="/cars">Cars</a></li>
                    <li><a href="/managers">Managers</a></li>
                    <li><a href="/deals">Deals</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="content">
    <form method="post" action="/cars">
        <label for="brandId">Brand: </label>
        <select name="brandId" id="brandId">
            <%for (Brand brand : (List<Brand>) request.getAttribute("brands")) {%>
            <option value="<%=brand.getId()%>"><%=brand.getName()%>
            </option>
            <%}%>
        </select>
        <a href="/cars/brands/new" id="common-link" style="font-size: 20px;"> new brand</a>
        <br> <br>
        <label for="model"> Model: </label>
        <input type="text" name="model" id="model">
        <br> <br>
        <label for="price"> Price: </label>
        <input type="text" name="price" id="price">

        <button type="submit">Add</button>
    </form>
</div>
</body>
</html>