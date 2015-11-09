<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="core.entity.Deal" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%Deal deal = (Deal) request.getAttribute("deal");%>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Deal <%=deal.getId()%>
    </title>

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
                    <li><a href="/managers">Managers</a></li>
                    <li><a href="/deals">Deals</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="content" align="center">
    <h1>Deal</h1>

    <h2>
        Car:
        <a href="/cars/<%=deal.getCar().getId()%>">
            <%=deal.getCar()%>
        </a>
    </h2>

    <h2>
        Manager:
        <a href="/managers/<%=deal.getManager().getId()%>">
            <%=deal.getManager()%>
        </a>
    </h2>

    <form method="post" action="/deals/<%=deal.getId()%>">
        <input type="hidden" name="_method" value="DELETE"/>
        <button type="submit" name="remove_deal" class="btn btn-danger">Remove</button>
    </form>
</div>
</body>
</html>