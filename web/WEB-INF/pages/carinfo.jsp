<%@ page import="core.entity.Car" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Manager</title>
  <link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
<div id="options">
  <a href="/cars" class="btn"> Cars </a> <br>
  <a href="/managers" class="btn"> Managers </a> <br>
  <a href="/deals" class="btn"> Deals </a> <br>
</div>
<div id="content">
  <%Car car = (Car) request.getAttribute("car");%>
  <h1> <%=car.getName()%></h1>
  <br> <br>
  <form method="post" action="/cars/<%=car.getId()%>/remove">
    <input type="submit" name="remove_car" value="remove">
  </form>
</div>
</body>
</html>