<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix = "c" uri =
"http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Insert title here</title>
        <link
            rel="stylesheet"
            href="/webjars/bootstrap/css/bootstrap.min.css"
        />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="col-md-3">
                <h1>Your Gold:${gold}</h1>
            </div>
        </div>
        <form action="/send" method="POST">
            <div class="row g-2 mt-2 g-3">
                <div class="col-md-3">
                    <div class="card p-3">
                        <h2>Farm</h2>
                        <p>(earns 10-20 gold)</p>
                        <button
                            class="btn-success m-3"
                            type="submit"
                            name="whichButton"
                            value="farm"
                        >
                            get some gold
                        </button>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card p-3">
                        <h2>Cave</h2>
                        <p>(earns 5-10 gold)</p>
                        <button
                            class="btn-success m-3"
                            type="submit"
                            name="whichButton"
                            value="cave"
                        >
                            get some gold
                        </button>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card p-3">
                        <h2>House</h2>
                        <p>(earns 2-5 gold)</p>
                        <button
                            class="btn-success m-3"
                            type="submit"
                            name="whichButton"
                            value="house"
                        >
                            get some gold
                        </button>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card p-3">
                        <h2>Casino!</h2>
                        <p>(earns/takes 0-50 gold)</p>
                        <button
                            class="btn-success m-3"
                            type="submit"
                            name="whichButton"
                            value="casino"
                        >
                            get some gold
                        </button>
                    </div>
                </div>
            </div>
        </form>
        <div class="container-md">
            <div style="height: 200px" class="border p-3 m-5 overflow-auto">
                <c:forEach var="message" items="${messages}">
                    <p><c:out value="${message}"></c:out></p>
                </c:forEach>
            </div>
        </div>

        <div class="container">
            <button class="btn" type="button">
                <a href="/delete"><button class="btn-primary" type="button"> Restart </button></a>
           
        </div>
    </body>
</html>
