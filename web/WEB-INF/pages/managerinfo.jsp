<%@ page import="java.util.List" %>
<%@ page import="core.entity.Deal" %>
<%@ page import="core.entity.Manager" %>
<%@ page import="core.entity.Brand" %>

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
  <%Manager manager = (Manager) request.getAttribute("manager");%>
  <h1> <%=manager.getName()%></h1>
  <form method="post" action="/managers/<%=manager.getId()%>/remove">
    <input type="submit" name="remove_manager" value="remove">
  </form>
  <table>
    <tr id="table-titles">
      <td> #</td>
      <td> ID</td>
      <td> MANAGER</td>
      <td> CAR</td>
      <td> PRICE</td>
    </tr>
    <%int i = 1;%>
    <%for (Deal deal : (List<Deal>) request.getAttribute("deals")) {%>
    <tr>
      <td>
        <%=i++%>
      </td>
      <td>
        <%=deal.getId()%>
      </td>
      <td>
        <%=deal.getManager().getName() + " (" + deal.getManager().getAge() + " y.o.)"%>
      </td>
      <td>
        <%=deal.getCar().getName()%>
      </td>
      <td>
        $<%=deal.getCar().getPrice()%>
      </td>
    </tr>
    <%}%>
  </table>
  <br> <br>
  <%Brand byDeals = (Brand) request.getAttribute("preferredBrandByDeals");%>
  <%Brand byPrice = (Brand) request.getAttribute("preferredBrandByPrice");%>
  <h2> Preferred brand by deals amount: <%=byDeals%></h2>
  <h2> Preferred brand by price amount: <%=byPrice%></h2>
</div>
</body>
</html>