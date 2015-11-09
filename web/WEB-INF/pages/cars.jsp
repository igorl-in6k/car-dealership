<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="core.entity.Car" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Cars</title>

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
                    <li class="active"><a href="/cars">Cars</a></li>
                    <li><a href="/managers">Managers</a></li>
                    <li><a href="/deals">Deals</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container">
    <%
        List<Car> cars = (List<Car>) request.getAttribute("cars");
        if (cars.isEmpty()) {%>
            <h1> No cars added yet</h1>
        <%}
        else {
    %>
    <table class="tables table-bordered table-responsive table-hover" align="center">
        <caption align="center">
            All Cars
        </caption>
        <thead>
        <tr>
            <th> #</th>
            <th> BRAND</th>
            <th> MODEL</th>
            <th> PRICE</th>
            <th> SALE DATE</th>
        </tr>
        </thead>


        <tbody>
        <%int i = 1;%>
        <%for (Car car : cars) {%>
        <tr>
            <td>
                <%=i++%>
            </td>
            <td>
                <a class="btn-link" href="/cars/<%=car.getId()%>">
                    <%=car.getBrand()%>
                </a>
            </td>
            <td>
                <a>
                    <%=car.getModel()%>
                </a>
            </td>
            <td>
                $
                <%=car.getPrice()%>
            </td>
            <td>
            <%if (!car.sold()) {%>
                <a href="/deals/new?car_id=<%=car.getId()%>"> sell </a>
            <%} else {%>
                <%=car.getSaleDate()%>
            <%}%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%}%>
    <div align="center">
        <br>
        <a class="btn-success btn-lg" href="/cars/new" style="margin: 0 10px"> Add car </a>
        <a class="btn-info btn-lg" href="/cars/brands"> All brands </a>
    </div>
</div>
</body>
</html>