<%@ page import="core.entity.Brand" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add car</title>
    <link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
<div id="options">
    <a href="/cars" class="btn"> Cars </a> <br>
    <a href="/managers" class="btn"> Managers </a> <br>
    <a href="/deals" class="btn"> Deals </a> <br>
</div>
<div id="content">
    <form method="post" action="/addcar">
        <label for="brand_id">Brand: </label>
        <select name="brand_id" id="brand_id">
            <%for (Brand brand : (List<Brand>)request.getAttribute("brands")) {%>
            <option value="<%=brand.getId()%>"><%=brand.getName()%></option>
            <%}%>
        </select>
        <a href="/addbrand" id="common-link" style="font-size: 20px;"> new brand</a>
        <br> <br>
        <label for="model"> Model: </label>
        <input type="text" name="model" id="model">
        <br> <br>
        <label for="price"> Price: </label>
        <input type="text" name="price" id="price">

        <input type="submit" name="add_car" value="add">
    </form>
</div>
</body>
</html>