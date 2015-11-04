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
  <a href="/cars" class="btn"> Cars </a> <br>
  <a href="/managers" class="btn"> Managers </a> <br>
  <a href="/deals" class="btn"> Deals </a> <br>
</div>

<div id="content">

  <h2> Choose car and manager: </h2> <br>
  <form action="/deals/new" method="post">
      <label for="carId">Choose car: </label>
      <select name="carId" id="carId">
          <%for (Car car : (List<Car>)request.getAttribute("cars")) {%>
          <option value="<%=car.getId()%>"><%=car.getName()%></option>
          <%}%>
      </select>
      <br>
      <label for="managerId">Choose manager: </label>
      <select name="managerId" id="managerId" >
          <%for (Manager manager : (List<Manager>)request.getAttribute("managers")) {%>
          <option value="<%=manager.getId()%>"><%=manager.getName()%></option>
          <%}%>
      </select>

      <input type="submit" name="sell_car" value="sell">
  </form>

</div>
</body>
</html>