<%@ page import="core.entity.Car" %>
<%@ page import="core.entity.Manager" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
<div id="options">
    <a href="${pageContext.request.contextPath}/cars" class="btn"> Cars </a> <br>
    <a href="/managers" class="btn"> Managers </a> <br>
    <a href="/deals" class="btn"> Deals </a> <br>
</div>

<div id="content">
    <%Car sellingCar = (Car) request.getAttribute("car"); %>
    <%String brand = sellingCar.getBrand().getName();%>
    <%String model = sellingCar.getModel();%>
    <h1 align="center"> Selling car: <%=brand + " " + model%>
    </h1>

    <%String action = "sellcar";
        action += request.getParameter("car_id") != null ? "?car_id=" + request.getParameter("car_id") : "";%>
    <form method="post" action="<%=action%>">
        <%
            if (request.getParameter("manager_id") == null) {
        %>
        <label for="manager_id">Choose manager: </label>
        <select name="manager_id" id="manager_id">
            <%for (Manager manager : (List<Manager>)request.getAttribute("managers")) {%>
            <option value="<%=manager.getId()%>"><%=manager.getName()%></option>
            <%}%>
        </select>
        <%
            }
        %>
        <%
            if (request.getParameter("car_id") == null) {
        %>
        <br>
        <label for="car_id">Choose car: </label>
        <select name="car_id" id="car_id">
            <%for (Car car : (List<Car>)request.getAttribute("cars")) {%>
            <option value="<%=car.getId()%>"><%=car.getBrand().getName()%> <%=car.getModel()%></option>
            <%}%>
        </select>
        <%
            }
        %>
        <input type="submit" name="sell" value="sell">
    </form>
</div>
</body>
</html>