<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>New Brand</title>

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
    <form method="post" action="/cars/brands/new">
        <label for="name"> Brand name: </label>
        <input type="text" name="name" id="name">

        <input type="submit" name="add_brand" value="add">
    </form>
</div>
</body>
</html>