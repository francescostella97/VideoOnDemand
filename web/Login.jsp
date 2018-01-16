<%--
  Created by IntelliJ IDEA.
  User: Utente
  Date: 18/12/2017
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="main-panel">

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

</div>

</body>
</html>
