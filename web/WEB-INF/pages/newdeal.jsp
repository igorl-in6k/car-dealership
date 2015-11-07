<%@ page import="core.entity.Car" %>
<%@ page import="core.entity.Manager" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>New Deal</title>

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

    <h2> Choose car and manager: </h2> <br>

    <h1>New Deal</h1>
    <form class="form-inline" role="form" method="post" action="/deals/new">
        <div class="form-group">
            <label for="carId">Car:</label>
            <select class="form-control" name="carId" id="carId">
                <%for (Car car : (List<Car>) request.getAttribute("cars")) {%>
                    <%String carIdParameter = request.getParameter("car_id");%>
                    <%if (carIdParameter != null && carIdParameter.equals(Integer.toString(car.getId()))) {%>
                        <option value="<%=car.getId()%>" selected="selected"> <%=car.getName()%>
                        </option>
                    <%} else {%>
                        <option value="<%=car.getId()%>"> <%=car.getName()%>
                        </option>
                    <%}%>
                <%}%>
            </select>
            <label for="managerId">Manager:</label>
            <select class="form-control" name="managerId" id="managerId">
                <%for (Manager manager : (List<Manager>) request.getAttribute("managers")) {%>
                <option value="<%=manager.getId()%>"><%=manager.getName()%>
                </option>
                <%}%>
            </select>
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</body>
</html>