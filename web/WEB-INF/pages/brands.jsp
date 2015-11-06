<%@ page import="java.util.List" %>
<%@ page import="core.entity.Brand" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Brands</title>

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
                    <li class="active"><a href="/cars">Cars</a></li>
                    <li><a href="/managers">Managers</a></li>
                    <li><a href="/deals">Deals</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="content">
    <table class="tables table-bordered table-responsive table-hover" align="center" width="60%">
        <thead>
        <tr id="table-titles">
            <th> #</th>
            <th> NAME</th>
            <th> REMOVE</th>
        </tr>
        </thead>
        <tbody>
        <%int i = 1;%>
        <%for (Brand brand : (List<Brand>) request.getAttribute("brands")) {%>
        <tr>
            <td>
                <%=i++%>
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
        </tbody>
    </table>
    <br> <a href="/cars/brands/new" class="common-link"> Add brand </a> <br>
</div>
</body>
</html>