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
    <h1>New Car</h1>
    <form class="form-inline" role="form" method="post" action="/cars">
        <div class="form-group">
            <label for="brandId">Brand:</label>
            <select class="form-control" name="brandId" id="brandId">
                <%for (Brand brand : (List<Brand>) request.getAttribute("brands")) {%>
                <option value="<%=brand.getId()%>"><%=brand.getName()%>
                </option>
                <%}%>
            </select>
        </div>
        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" name="model" id="model" class="form-control">
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" name="price" id="price" class="form-control">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</body>
</html>