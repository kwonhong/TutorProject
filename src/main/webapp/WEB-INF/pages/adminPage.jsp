<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Admin Dashboard</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>
<body>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">FootyFix</a>
        </div>

        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Sign Out</a></li>
            </ul>
        </div>
    </div>
</nav>
</head>
<body>

<div class="container">
    <table>
        <tr><form role="search" action="/search">
            <td>
                <input name="searchText" type="text" class="form-control" placeholder="Search Events" size = "60">
            </td>
            <td>
                <button class="btn btn-default" type="submit">Go!</button>
            </td></form>
        </tr>
    </table>
</div>
<div>
    <h2>Soccer Events</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Event Name</th>
            <th># Participants</th>
            <th># Available Spots</th>
            <th>Date</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="event" items="${eventList}">
            <tr>
                <form role="eventReservation" method="POST" name="${event.id}">
                    <td>${event.name}</td>
                    <td>${event.getNumParticipants()}</td>
                    <td>${event.getCapacity() - event.getNumParticipants()}</td>
                    <td>${event.date}</td>
                    <input type="hidden" name="eventid" value="${event.id}"/>
                    <td>
                        <button type="submit" href="index.html" class="btn btn-sm" onclick="form.action='eventDelete'">
                            Cancel
                        </button>
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
<form name = "createEvent" method = "POST">
    <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block" onClick="form.action='eventCreate'">Create New</button>
</form>
</body>
</html>
