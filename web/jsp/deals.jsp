<%@ page import="java.util.List" %>
<%@ page import="core.entity.Deal" %>

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
                <a href="/managerinfo?id=<%=deal.getManager().getId()%>" id="common-link" style="font-size: 25px;">
                    <%=deal.getManager().getName() + " (" + deal.getManager().getAge() + " y.o.)"%>
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
    </table>
</div>
</body>
</html>