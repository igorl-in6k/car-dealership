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
<div class="content">
    <h1><%=manager.getName()%>
    </h1>

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
    <h2> Preferred brand by deals amount: <%=byDeals%>
    </h2>

    <h2> Preferred brand by price amount: <%=byPrice%>
    </h2>
</div>
</body>
</html>