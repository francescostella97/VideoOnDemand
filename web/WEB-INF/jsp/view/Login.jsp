<%--
  Created by IntelliJ IDEA.
  User: Utente
  Date: 18/12/2017
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/WEB-INF/jsp/header.jspf"%>

    <head>
        <title>Title</title>

        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="../../../assets/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="../../../assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>List of Products</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />


        <!-- Bootstrap core CSS     -->
        <link href="../../../assets/css/bootstrap.min.css" rel="stylesheet" />

        <!-- Animation library for notifications   -->
        <link href="../../../assets/css/animate.min.css" rel="stylesheet"/>

        <!--  Paper Dashboard core CSS    -->
        <link href="../../../assets/css/paper-dashboard.css" rel="stylesheet"/>

        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="../../../assets/css/demo.css" rel="stylesheet" />

        <!--  Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="../../../assets/css/themify-icons.css" rel="stylesheet">

    </head>

<body>
<div class="wrapper">
<%@include file="/WEB-INF/jsp/sidebar.jspf"%>


            <div class="main-panel">

                <%@include file="/WEB-INF/jsp/navbar.jspf"%>

                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <form action = <%=response.encodeURL("/loginServlet")%> method="post">
                                Per accedere a tutte le funzionalita' si prega di eseguire il login.
                                <br> <br>
                                Username <input type="text" name="username"> <br> <br>
                                Password <input type="password" name="password"><br> <br>

                                <input class="btn btn-info btn-fill btn-wd" type='submit' value='submit'/> <br><br> <br><br>
                            </form>
                        </div>
                    </div>
                </div>

                <%@include file="/WEB-INF/jsp/footer.jspf"%>
            </div>
</div>
</body>
</html>
