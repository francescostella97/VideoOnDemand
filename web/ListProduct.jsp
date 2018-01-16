
<%--
  Created by IntelliJ IDEA.
  UserEntity: Utente
  Date: 28/11/2017
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<c:set var="films" value="${requestScope.get('elements')}" scope="session"></c:set>

<a href=<%=response.encodeURL("/listProductServlet?orderingType=sort_alpha")%>><img src="img/sort_alpha.png"></a>
<a href=<%=response.encodeURL("/listProductServlet?orderingType=sort_numeric")%>><img src="img/sort_numeric.png"></a>

Ricorda questa scelta <input type="checkbox" name="list_type">



    <div class="main-panel">

        <div class="content">
            <div class="container-fluid">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card card-plain">
                            <div class="header">
                                <h4 class="title">Film </h4>
                                <p class="category">There are <c:out value="${films.size()}"></c:out> films in our database</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover">
                                    <thead>
                                    <th>Title</th>
                                    <th>Genre</th>
                                    <th>Year</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${films}" var="f">
                                        <tr>
                                            <td>${f.title}</td>
                                            <td>${f.genre.name}</td>
                                            <td>${f.year}</td>
                                            <td><a href="/loadListFormServlet?id=${f.id}" ><img src="img/edit.png" ></a></td>
                                            <td><a href="/deleteFilmServlet?id=${f.id}" ><img src="img/delete.png" ></a></td>
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

    </div>


















</body>
</html>