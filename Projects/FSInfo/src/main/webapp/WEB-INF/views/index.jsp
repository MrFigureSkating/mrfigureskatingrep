<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FS-info</title>

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
                                        <li><a href="info">База знаний</a></li>
                                        <li><a href="#">Поиск тренера</a></li>
                                        <li><a href="#">Поиск школы/катка</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Слайдер-->
                    <div class="row">
                        <div id="carousel" class="carousel slide">
                            <ol class="carousel-indicators">
                                <li class="active" data-target="#carousel" data-slide-to="0"></li>
                                <li data-target="#carousel" data-slide-to="1"></li>
                                <li data-target="#carousel" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="<c:url value="/resources/images/4.jpg" />" alt="">
                                    <div class="carousel-caption">
                                        <h3>Первый</h3>
                                        <p>описание первого слайда</p>
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="<c:url value="/resources/images/4.jpg" />" alt="">
                                    <div class="carousel-caption">
                                        <h3>Второй</h3>
                                        <p>описание второго слайда</p>
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="<c:url value="/resources/images/4.jpg" />" alt="">
                                    <div class="carousel-caption">
                                        <h3>Третий</h3>
                                        <p>описание третьего слайда</p>
                                    </div>
                                </div>
                            </div>
                            <a href="#carousel" class="left carousel-control" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
                            <a href="#carousel" class="right carousel-control" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                        </div>
                    </div>


                </div>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-1 hidden-xs"></div>
        </div>
        <div class="row content">
            <div class="col-lg-2 col-md-2 col-sm-1 hidden-xs"></div>
            <div class="col-lg-8 col-md-8 col-sm-10 col-xs-12">

                <div class="container-fluid marketing">

                    <div class="row">
                        <div class="col-lg-4">
                            <i class="fa fa-book fa-5x"></i>
                            <!--<img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" style="width: 140px; height: 140px;">-->
                            <h2>База знаний</h2>
                            <p>Хотите узнать о любимом фигуристе или посмотреть результаты соревнований? Мы собрали для вас информацию о фигуристах, их тренерах, соревнованиях, правилах, и о многом другом!</p>
                            <p><a class="btn btn-primary" href="info" role="button">Узнать больше &raquo;</a></p>
                        </div>
                        <div class="col-lg-4">
                            <i class="fa fa-user fa-5x"></i>
                            <!--<img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" style="width: 140px; height: 140px;">-->
                            <h2>Найди своего тренера.</h2>
                            <p>Не хочешь выглядеть как корова на льду? Хорошо. Мы поможем найти тебе доброго сенсея. Или может хочешь выступать за страну? В любом случае индивидуальные тренеры здесь.</p>
                            <p><a class="btn btn-primary" href="#" role="button">Узнать больше &raquo;</a></p>
                        </div>
                        <div class="col-lg-4">
                            <i class="fa fa-university fa-5x"></i>
                            <!--<img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" style="width: 140px; height: 140px;">-->
                            <h2>Найди школу/каток</h2>
                            <p>Ищешь школу фигурного катания или просто место, где можно покататься? Тогда ты пришел по адресу. Блин, красноречие закончилось, короче жми сюда.</p>
                            <p><a class="btn btn-primary" href="#" role="button">Узнать больше &raquo;</a></p>
                        </div>
                    </div>
                </div>


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
