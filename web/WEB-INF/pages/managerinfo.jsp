<%@ page import="java.util.List" %>
<%@ page import="core.entity.Deal" %>
<%@ page import="core.entity.Manager" %>
<%@ page import="core.entity.Brand" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%Manager manager = (Manager) request.getAttribute("manager");%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title><%=manager.getName()%>
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
    <h1>
        <%=manager.getName() + " (" + manager.getAge() + " y.o.)" %>
    </h1>
    <%
        List<Deal> deals = (List<Deal>) request.getAttribute("deals");
        if (!deals.isEmpty()) {
    %>
    <table class="tables table-bordered table-responsive table-hover" align="center" width="60%">
        <caption>
            Manager Deals
        </caption>
        <thead>
        <tr>
            <th> #</th>
            <th> ID</th>
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
                <%=i++%>
            </td>
            <td>
                <%=deal.getId()%>
            </td>
            <td>
                <a href="/managers/<%=deal.getManager().getId()%>">
                    <%=deal.getManager().getName()%>
                </a>
            </td>
            <td>
                <a href="/cars/<%=deal.getCar().getId()%>">
                    <%=deal.getCar().getName()%>
                </a>
            </td>
            <td>
                $<%=deal.getCar().getPrice()%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%} else {%>
    <h1> No deals added yet</h1>
    <%}%>
    <br> <br>
    <%Brand byDeals = (Brand) request.getAttribute("preferredBrandByDeals");%>
    <%Brand byPrice = (Brand) request.getAttribute("preferredBrandByPrice");%>
    <h2> Preferred brand by deals amount: <%=byDeals%>
    </h2>

    <h2> Preferred brand by price amount: <%=byPrice%>
    </h2>

    <div align="center">
        <form method="post" action="/managers/<%=manager.getId()%>">
            <input type="hidden" name="_method" value="DELETE"/>
            <button type="submit" name="remove_manager" class="btn btn-danger">Remove</button>
            <a class="btn-info btn-lg" href="/managers/<%=manager.getId()%>/edit" style="margin: 0 10px">
                Edit
            </a>
        </form>
    </div>

</div>
</body>
</html>