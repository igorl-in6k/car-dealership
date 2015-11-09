<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="core.entity.Car" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%Car car = (Car) request.getAttribute("car");%>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title><%=car.getName()%>
    </title>

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
<div class="content" align="center">
    <h1><%=car.getName()%>
    </h1>
    <br> <br>

    <div align="center">
        <form method="post" action="/cars/<%=car.getId()%>">
            <input type="hidden" name="_method" value="DELETE"/>
            <button type="submit" name="remove_car" class="btn btn-danger">Remove</button>
            <a class="btn-info btn-lg" href="/cars/<%=car.getId()%>/edit" style="margin: 0 10px">
                Edit
            </a>
        </form>
    </div>
</div>

</body>
</html>