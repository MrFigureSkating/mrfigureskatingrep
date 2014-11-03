<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/lib/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/lib/css/font-awesome.css" />" rel="stylesheet">

</head>
<body>
<!--Главный контейнер -->

<div id="mainContainer" class="container-fluid">
    <div class="row header">
        <div class="col-lg-2 col-md-2 col-sm-1 hidden-xs"></div>
        <div class="col-lg-8 col-md-8 col-sm-10 col-xs-12">
        <div class="container-fluid head">

            <!--Навигация-->
            <div class="row">
                <div class="navbar navbar-default navbar-static-top" role="navigation">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Открыть навигацию</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="main">FS-info</a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="#">О фигурном катании</a></li>
                                <li><a href="#">Люди</a></li>
                                <li><a href="#">Соревнования</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        </div>
        <div class="col-lg-2 col-md-2 col-sm-1 hidden-xs"></div>
    </div>
    <div class="row content">
        <div class="col-lg-2 col-md-2 col-sm-1 hidden-xs"></div>
        <div class="col-lg-8 col-md-8 col-sm-10 col-xs-12">



        </div>
        <div class="col-lg-2 col-md-2 col-sm-1 hidden-xs"></div>
    </div>
    <div class="row footer">
        <div class="col-lg-2 col-md-2 col-sm-1 hidden-xs"></div>
        <div class="col-lg-8 col-md-8 col-sm-10 col-xs-12"></div>
        <div class="col-lg-2 col-md-2 col-sm-1 hidden-xs"></div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value="/resources/lib/js/jquery-2.1.1.js" />"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/resources/lib/js/bootstrap.js" />"></script>
</body>
</html>
