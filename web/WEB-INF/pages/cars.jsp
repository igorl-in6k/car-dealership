<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="core.entity.Car" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Cars Main</title>
  <link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
</head>
<body>
<div id="options">
  <a href="/cars" class="btn"> Cars </a>
  <a href="/managers" class="btn"> Managers </a>
  <a href="/deals" class="btn"> Deals </a>
</div>
<div id="content">
  <h1> All Cars </h1>
  <table>
    <tr id="table-titles">
      <td> #</td>
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
        <a class="common-link" href="/cars/<%=car.getId()%>">
            <%=car.getBrand()%>
        </a>
      </td>
      <td>
        <a class="common-link" href="/cars/<%=car.getId()%>">
          <%=car.getModel()%>
        </a>
      </td>
      <td>
        $
        <%=car.getPrice()%>
      </td>
      <%if ("".equals(car.getSaleDate())){%>
      <td>
        <a href="/deals/new?car_id=<%=car.getId()%>" class="common-link"> sell </a>
      </td>
      <%} else {%>
      <td>
        <%=car.getSaleDate()%>
      </td>
      <%}%>
    </tr>
    <%}%>
  </table>
  <br> <a href="/cars/new" class="common-link"> Add car </a> <br>
  <br> <a href="/cars/brands" class="common-link"> All brands </a> <br>
</div>
</body>
</html>