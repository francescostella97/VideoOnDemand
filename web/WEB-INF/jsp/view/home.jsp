<%--
  Created by IntelliJ IDEA.
  User: Utente
  Date: 28/11/2017
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

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

                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Cos'è Video On Demand</h4>
                            </div>
                            <div class="content">
                                Il video on demand, è un servizio interattivo della televisione.
                                Il servizio permette agli utenti di fruire, gratuitamente o a pagamento, di un programma televisivo in qualsiasi momento lo desiderino.


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/jsp/footer.jspf"%>

    </div>
</div>
</body>
</html>



