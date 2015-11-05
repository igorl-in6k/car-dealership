<%@ page import="java.util.List" %>
<%@ page import="core.entity.Deal" %>
<%@ page import="core.entity.Brand" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Deals</title>
  <link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
<div id="options">
  <a href="/cars" class="btn"> Cars </a> <br>
  <a href="/managers" class="btn"> Managers </a> <br>
  <a href="/deals" class="btn"> Deals </a> <br>
</div>
<div id="content">
  <table>
    <tr id="table-titles">
      <td> #</td>
      <td> ID</td>
      <td> NAME</td>
      <td> REMOVE</td>
    </tr>
    <%int i = 1;%>
    <%for (Brand brand : (List<Brand>) request.getAttribute("brands")) {%>
    <tr>
      <td>
        <%=i++%>
      </td>
      <td>
        <%=brand.getId()%>
      </td>
      <td>
        <%=brand.getName()%>
      </td>
      <td>
        <form method="post" action="/cars/brands/<%=brand.getId()%>/remove">
          <input type="submit" name="remove_brand" value="remove">
        </form>
      </td>
    </tr>
    <%}%>
  </table>
  <br> <a href="/cars/brands/new" class="common-link"> Add brand </a> <br>
</div>
</body>
</html>