<%@ page import="core.entity.Car" %>
<%@ page import="core.entity.Manager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
<div id="options">
    <a href="/cars" class="btn"> Cars </a> <br>
    <a href="/managers" class="btn"> Managers </a> <br>
    <a href="/deals" class="btn"> Deals </a> <br>
</div>
<div id="content">
    <%Car car = (Car) request.getAttribute("car");
      Manager manager = (Manager) request.getAttribute("manager");%>
    <h1 align="center"> Sold car <%=car.getName()%> by <%=manager.getName()%></h1>
</div>
</body>
</html>