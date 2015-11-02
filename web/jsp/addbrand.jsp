<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add brand</title>
    <link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
<div id="options">
    <a href="/cars" class="btn"> Cars </a> <br>
    <a href="/managers" class="btn"> Managers </a> <br>
    <a href="/deals" class="btn"> Deals </a> <br>
</div>
<div id="content">
    <form method="post" action="/addbrand">
        <label for="name"> Brand name: </label>
        <input type="text" name="name" id="name">

        <input type="submit" name="add_car" value="add">
    </form>
</div>
</body>
</html>