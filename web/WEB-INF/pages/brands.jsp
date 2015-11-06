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
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Automobile Dealership</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/cars">CARS</a></li>
                    <li><a href="/managers">MANAGERS</a></li>
                    <li><a href="/deals">DEALS</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </nav>
</div>
<div class="content">
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