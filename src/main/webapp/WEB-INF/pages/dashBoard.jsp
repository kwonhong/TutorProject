<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FootyFix Events Page</title>
    <%--<style>--%>
    <%--@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);--%>

    <%--body {--%>
    <%--margin: 0;--%>
    <%--padding: 0;--%>
    <%--background-image: url(http://i.imgur.com/4a2H5lF.jpg);--%>
    <%---webkit-background-size: cover;--%>
    <%---moz-background-size: cover;--%>
    <%---o-background-size: cover;--%>
    <%--background-size: cover;--%>
    <%--color: #fff;--%>
    <%--font-family: 'Exo';--%>
    <%--font-size: 12px;--%>
    <%--}--%>

    <%--.asText {--%>
    <%--background: none;--%>
    <%--border: none;--%>
    <%--margin: 0;--%>
    <%--padding: 0;--%>
    <%--color: #fff;--%>
    <%--font-family: 'Exo';--%>
    <%--font-size: 15px;--%>
    <%--font-weight: bold;--%>
    <%--}--%>
    <%--</style>--%>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>


<%--Welcome ${currentUser.firstname}--%>
<%--<br>${currentUser.city}--%>
<%--<form role="logout" method="POST">--%>
<%--<button class="asText" onclick="form.action='myPage'">My Page</button>--%>
<%--</form>--%>
<%--<p></p>--%>

<%--<form role="logout" method="POST">--%>
<%--<button class="asText" onclick="form.action='logout'">Log Out</button>--%>
<%--</form>--%>
<%--<hr>--%>

<%--<c:forEach var="event" items="${eventList}">--%>
<%--<form role="eventReservation" method="POST" name="${event.id}">--%>
<%--<table>--%>
<%--<span><p style="font-size:20px" style="font-weight:bold">--%>
<%--<c style="color:lawngreen">${event.name}</c>--%>
<%--</p></span>--%>
<%--<tr>--%>
<%--<td>Currently Attending: ${event.getNumParticipants()}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>Spots Available: ${event.getCapacity() - event.getNumParticipants()}</td>--%>
<%--</tr>--%>
<%--<td><input type="hidden" name="userid" value="${currentUser.id}"/>--%>
<%--<input type="hidden" name="eventid" value="${event.id}"/>--%>
<%--<button type="submit" href="index.html" class="btn btn-lg btn-success btn-block"--%>
<%--onclick="form.action='eventRsvp'">RSVP--%>
<%--</button>--%>
<%--</td>--%>
<%--</table>--%>
<%--</form>--%>
<%--</c:forEach>--%>


<div class="container">

    <br><br>

    <div class="row">
        <form role="search" action="/search">
            <div class="search">
                <div class="col-lg-6">
                    <input name="searchText" type="text" class="form-control" placeholder="Search Tutorial">
                </div>
                    <button class="btn btn-default" type="submit">Go!</button>
            </div>
        </form>
    </div>
    <h2>Soccer Events</h2>

    <p>Please select soccer events you want to participate:</p>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Event Name</th>
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
                    <td>${event.getNumParticipants()}</td>
                    <td>${event.getCapacity() - event.getNumParticipants()}</td>
                    <input type="hidden" name="userid" value="${currentUser.id}"/>
                    <input type="hidden" name="eventid" value="${event.id}"/>
                    <td>
                        <button type="submit" href="index.html" class="btn btn-sm" onclick="form.action='eventRsvp'">
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
