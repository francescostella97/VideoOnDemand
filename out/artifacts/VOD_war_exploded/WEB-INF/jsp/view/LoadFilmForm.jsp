<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html> <%@include file="/WEB-INF/jsp/header.jspf"%>
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
<%!
    public String checkParam(HttpServletRequest request, String param){
        return request.getParameter(param)== null? "" : request.getParameter(param);
    }
%>

<%--<c:set var="errors" value="${requestScope.get('errors')}"></c:set>--%>

<%--<c:set var="id" value="" scope="page"></c:set>--%>
<%--<c:set var="title" value="" scope="page"></c:set>--%>
<%--<c:set var="genre" value="" scope="page"></c:set>--%>
<%--<c:set var="year" value="" scope="page"></c:set>--%>
<%--<c:set var="cover" value="" scope="page"></c:set>--%>
<%--<c:set var="genres" value="${requestScope.get('genres')}" scope="page"></c:set>--%>

<%--<c:set var="dtoFilm" value="${requestScope.get('FilmEntity')}" scope="page"></c:set>--%>


<c:if test="${!empty dtoUser && dtoUser.role == 1}" var="adminUser">
    <c:if test="${adminUser}">

        <c:if test="${! empty dtoUser}">

            <c:set var="id" value="${dtoFilm.id}" scope="page"></c:set>
            <c:set var="title" value="${dtoFilm.title}" scope="page"></c:set>
            <c:set var="genre" value="${dtoFilm.genre}" scope="page"></c:set>
            <c:set var="year" value="${dtoFilm.year}" scope="page"></c:set>
            <c:set var="cover" value="${dtoFilm.cover}" scope="page"></c:set>
        </c:if>

    </c:if>

    <c:if test="${not adminUser}">
        <c:redirect url="Login.jsp"></c:redirect>
    </c:if>
</c:if>

<%--<%  /*String id = "";
    String title = "";
    String genre = "";
    String year = "";
    String cover = "";*/
    Map<Integer, String> genres = new HashMap<>();
    //List<String> errors = new ArrayList<>();

    if(dtoUser != null && dtoUser.role == 1){
        DAOFactory factory = DAOFactory.createFactory(DAOFactory.PersistenceType.JDBC);
        genres = factory.getGenereDAO().getAllGenres();
        //errors = (List<String>) request.getAttribute("errors");

        DTOFilm dtoFilm = (DTOFilm) request.getAttribute("DTOFilm");

        /*if(dtoFilm != null){
            //update
            id = String.valueOf(dtoFilm.id);
            title = dtoFilm.title;
            genre = dtoFilm.genre_name;
            year = String.valueOf(dtoFilm.year);
            cover = dtoFilm.cover;
        }*/
    }
    else{
        response.sendRedirect(response.encodeURL("Login.jsp"));
        //request.getRequestDispatcher("Login.jsp").forward(request,response);
    }

    /*String title = Validate.checkParam(request,"title");
    String genre = Validate.checkParam(request,"genre");
    String year = Validate.checkParam(request,"year");*/
%>--%>
<div class="wrapper">
    <%@include file="/WEB-INF/jsp/sidebar.jspf"%>


    <div class="main-panel">

        <%@include file="/WEB-INF/jsp/navbar.jspf"%>

        <div class="content">
            <div class="container-fluid">
                <div class="row">

                    <sf:form commandName="item" method="post">

                        Title <sf:input path="title"/>
                        <sf:errors path="title" cssClass="error"/>

                        <sf:select path="genre" >
                            <form:options items="${genres}" />
                        </sf:select>

                        Year <sf:input path="year"/>
                        <sf:errors path="year" cssClass="error"/>


                        <input type="submit" value="Save">

                    </sf:form>




                    <%--<form action='/loadListFormServlet?status=full' method='POST' enctype="multipart/form-data">--%>

                        <%--<input type="hidden" name="filmId" value="${id}"/>--%>
                        <%--<img src="${cover}"></img>--%>

                        <%--Title <input type='text' name='title' value='${title}'/> <br><br>--%>

                        <%--Cover <input type="file" name="cover"/> <br><br>--%>

                        <%--Genere <select name='genre'>--%>

                        <%--<c:forEach items="${genres}" var="current" >--%>

                            <%--<c:if test="${current.id.equals(genre.id)}">--%>
                                <%--<option value="${current.id}" selected> ${current.name} </option>--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${!current.id.equals(genre.id)}">--%>
                                <%--<option value="${current.id}"> ${current.name} </option>--%>
                            <%--</c:if>--%>

                        <%--</c:forEach>--%>
                    <%--</select>--%>

                        <%--</select> <br><br>--%>
                        <%--Year <input type='text' name='year' value='${year}'/> <br><br>--%>
                        <%--<input class="btn btn-info btn-fill btn-wd" type='submit' value='submit'/> <br><br>--%>
                        <%--&lt;%&ndash;<button type="submit" class="btn btn-info btn-fill btn-wd">Update Profile</button>&ndash;%&gt;--%>


                        <%--<c:if test="${!empty errors}">--%>
                            <%--<div class="alert alert-danger">--%>
                                <%--<button type="button" aria-hidden="true" class="close">×</button>--%>
                                <%--<span><b> Danger - </b> This is a regular notification made with ".alert-danger"</span>--%>
                                <%--<c:forEach items="${errors}" var="e">--%>
                                    <%--<li>${e}</li>--%>
                                <%--</c:forEach>--%>
                            <%--</div>--%>

                        <%--</c:if>--%>


                    <%--</form>--%>


                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/jsp/footer.jspf"%>

    </div>
</div>



</body>
</html>





