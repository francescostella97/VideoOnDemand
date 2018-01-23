
<%--
  Created by IntelliJ IDEA.
  UserEntity: Utente
  Date: 28/11/2017
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html> <%@include file="/WEB-INF/jsp/header.jspf"%>

<head>
    <title>List products</title>

    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>List of Products</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/themify-icons.css" rel="stylesheet">

</head>

<body>

<c:set var="films" value="${requestScope.get('elements')}" scope="session"></c:set>

<div class="wrapper">
    <%@include file="/WEB-INF/jsp/sidebar.jspf"%>


    <div class="main-panel">

        <%@include file="/WEB-INF/jsp/navbar.jspf"%>

        <div class="content">
            <div class="container-fluid">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card card-plain">
                            <div class="header">
                                <h4 class="title">Film </h4>
                                <p class="category">There are <c:out value="${films.size()}"></c:out> films in our database</p>
                            </div>

                            <a href=<%=response.encodeURL("/listProductServlet?orderingType=sort_alpha")%>><img src="img/sort_alpha.png"></a>
                            <a href=<%=response.encodeURL("/listProductServlet?orderingType=sort_numeric")%>><img src="img/sort_numeric.png"></a>

                            Ricorda questa scelta <input type="checkbox" name="list_type">
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover">
                                    <thead>
                                    <th>Title</th>
                                    <th>Genre</th>
                                    <th>Year</th>
                                    <th></th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${films}" var="f">
                                        <tr>
                                            <td>${f.title}</td>
                                            <td>${f.genre.name}</td>
                                            <td>${f.year}</td>
                                            <td><a href="/deleteFilmServlet?id=${f.id}" ><i class="ti-shopping-cart"></i></a></td>
                                            <td><a href="/loadListFormServlet?id=${f.id}" ><i class="ti-pencil"></i></a></td>
                                            <td><a href="/deleteFilmServlet?id=${f.id}" ><i class="ti-trash"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

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

