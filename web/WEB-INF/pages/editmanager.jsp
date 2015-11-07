<%@ page import="core.entity.Manager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Edit Manager</title>

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
  <%Manager manager = (Manager) request.getAttribute("manager");%>
  <h1>Edit manager</h1>
  <form class="form-inline" role="form" method="post" action="/managers/<%=manager.getId()%>">
      <input type="hidden" name="_method" value="PATCH"/>
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" name="name" id="name" value="<%=manager.getName()%>">
    </div>
    <div class="form-group">
      <label for="age">Age:</label>
      <input type="number" name="age" class="form-control" id="age" value="<%=manager.getAge()%>">
    </div>
    <button type="submit" class="btn btn-default">edit</button>
  </form>
</div>
</body>
</html>