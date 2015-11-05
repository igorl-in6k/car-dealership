<%@ page import="java.util.List" %>
<%@ page import="core.entity.Manager" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Managers</title>
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
      <td> AGE</td>
    </tr>
    <%int i = 1;%>
    <%for (Manager manager : (List<Manager>) request.getAttribute("managers")) {%>
    <tr>
      <td>
        <%=i++%>
      </td>
      <td>
        <%=manager.getId()%>
      </td>
      <td>
        <a class="common-link" href="managers/<%=manager.getId()%>"> <%=manager.getName()%> </a>
      </td>
      <td>
        <%=manager.getAge()%>
      </td>
    </tr>
    <%}%>
  </table>
  <br> <a href="/managers/new" class="common-link"> Add manager </a> <br>
</div>
</body>
</html>