<%@ page import="java.util.List" %>
<%@ page import="core.entity.Deal" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Deals</title>

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
                    <li class="active"><a href="/deals">Deals</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="content" align="center">
    <%
        List<Deal> deals = (List<Deal>) request.getAttribute("deals");
        if (deals.isEmpty()) {%>
    <h1> No deals added yet</h1>
    <%}
    else {
    %>
    <table class="tables table-bordered table-responsive table-hover" align="center" width="60%">
        <caption>
            All Deals
        </caption>
        <thead>
        <tr id="table-titles">
            <th> #</th>
            <th> MANAGER</th>
            <th> CAR</th>
            <th> PRICE</th>
        </tr>
        </thead>
        <tbody>
        <%int i = 1;%>
        <%for (Deal deal : deals) {%>
        <tr>
            <td>
                <a href="deals/<%=deal.getId()%>">
                    <%=i++%>
                </a>
            </td>
            <td>
                <a href="/managers/<%=deal.getManager().getId()%>" id="common-link" style="font-size: 25px;">
                    <%=deal.getManager().getName()%>
                </a>
            </td>
            <td>
                <%=deal.getCar().getName()%>
            </td>
            <td>
                $<%=deal.getCar().getPrice()%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%}%>
    <br>
    <div align="center">
        <a class="btn-success btn-lg" href="/deals/new"> New deal </a> <br>
    </div>
</div>
</body>
</html>