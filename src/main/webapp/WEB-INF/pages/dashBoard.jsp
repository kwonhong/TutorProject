<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FootyFix Events Page</title>

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
            <ul class="nav navbar-nav">
                <li><a href="/myPage">My Page</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Sign Out</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <table>
        <tr><form role="search" action="/search">
            <td>
                <input name="searchText" type="text" class="form-control" placeholder="Search Events" size = "60">
            </td>
            <td>
                <button class="btn btn-default" type="submit">Go!</button>
            </td>
        </form>
            <form role="search near by" action="/searchNear">
            <td><button class="btn btn-default" type="submit">Near Me</button>
            </td>
            </form>

        </tr>
    </table>
</div>
<div>
    <h2>Soccer Events</h2>

    <p>Please select soccer events you want to participate:</p>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Venue Name</th>
            <th>Game Date</th>
            <th># Participants</th>
            <th># Available Spots</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="event" items="${eventList}">
            <tr>
                <form role="eventReservation" method="POST" name="${event.id}">
                    <td>${event.name}</td>
                    <td>${event.date}</td>
                    <td>${event.getNumParticipants()}</td>
                    <td>${event.getCapacity() - event.getNumParticipants()}</td>
                    <input type="hidden" name="userid" value="${currentUser.id}"/>
                    <input type="hidden" name="eventid" value="${event.id}"/>
                    <td>
                        <button type="submit" href="index.html" class="btn btn-sm" onclick="form.action='eventDetails'">
                            RSVP
                        </button>
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%--<a class = "btn btnPrimary" href="<c:url value='/eventCreate' />"> <i class="fa fa-edit fa-fw"></i>Create Event</a>--%>

</body>
</html>
