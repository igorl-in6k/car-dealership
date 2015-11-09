<%@ page import="java.util.List" %>
<%@ page import="core.entity.Manager" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Managers</title>

    <link href="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header-bar">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">Automobile Dealership</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li><a href="/">Home</a></li>
                    <li><a href="/cars">Cars</a></li>
                    <li class="active"><a href="/managers">Managers</a></li>
                    <li><a href="/deals">Deals</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="content" align="center">
    <%
        List<Manager> managers = (List<Manager>) request.getAttribute("managers");
        if (managers.isEmpty()) {%>
    <h1> No managers added yet</h1>
    <%}
    else {
    %>
    <table class="tables table-bordered table-responsive table-hover" align="center" width="60%">
        <caption>
            All managers
        </caption>
        <thead>
        <tr>
            <th> #</th>
            <th> NAME</th>
            <th> AGE</th>
        </tr>
        </thead>
        <tbody>
        <%int i = 1;%>
        <%for (Manager manager : managers) {%>
        <tr>
            <td>
                <%=i++%>
            </td>
            <td>
                <a href="managers/<%=manager.getId()%>">
                    <%=manager.getName()%>
                </a>
            </td>
            <td>
                <%=manager.getAge()%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%}%>
    <br>
    <div align="center">
        <a class="btn-success btn-lg" href="/managers/new"> Add manager </a>
    </div>
</div>
</body>
</html>