<%@ page import="core.entity.Car" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars Main</title>
    <link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
<div id="options">
    <a href="/cars" class="btn"> Cars </a> <br>
    <a href="/managers" class="btn"> Managers </a> <br>
    <a href="/deals" class="btn"> Deals </a> <br>
</div>
<div id="content">
    <h1> All Cars </h1>
    <table>
        <tr id="table-titles">
            <td> #</td>
            <td> ID</td>
            <td> BRAND</td>
            <td> MODEL</td>
            <td> PRICE</td>
            <td> SALE DATE</td>
        </tr>
        <%int i = 1;%>
        <%for (Car car : (List<Car>) request.getAttribute("cars")) {%>
        <tr>
            <td>
                <%=i++%>
            </td>
            <td>
                <%=car.getId()%>
            </td>
            <td>
                <%=car.getBrand()%>
            </td>
            <td>
                <%=car.getModel()%>
            </td>
            <td>
                $
                <%=car.getPrice()%>
            </td>
            <%if (car.getSaleDate().equals("")) {%>
            <td>
                <a href="sellcar?car_id=<%=car.getId()%>" id="common-link"> sell </a>
            </td>
            <%} else {%>
            <td>
                <%=car.getSaleDate()%>
            </td>
            <%}%>
        </tr>
        <%}%>
    </table>
    <br> <a href="/addcar" id="common-link"> Add car </a> <br>
    <br> <a href="/addbrand" id="common-link"> Add brand </a> <br>
</div>
</body>
</html>