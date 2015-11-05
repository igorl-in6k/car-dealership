<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add manager</title>
  <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<div id="options">
  <a href="/cars" class="btn"> Cars </a> <br>
  <a href="/managers" class="btn"> Managers </a> <br>
  <a href="/deals" class="btn"> Deals </a> <br>
</div>
<div id="content">
  <form method="post" action="/managers/new">
    <label for="name"> Name: </label>
    <input type="text" name="name" id="name">
    <br> <br>
    <label for="age"> Age: </label>
    <input type="text" name="age" id="age">

    <input type="submit" name="add_manager" value="add">
  </form>
</div>
</body>
</html>