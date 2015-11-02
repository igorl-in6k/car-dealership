<%@ page import="core.entity.Manager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Added car</title>
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
    <h1> Added manager: <%=manager.getName() + "(" + manager.getAge() + " y.o.)"%></h1>
</div>
</body>
</html>