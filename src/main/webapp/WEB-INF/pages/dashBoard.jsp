<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FootyFix Events Page</title>
    <style>
        @import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
        body{
            margin: 0;
            padding: 0;
            background-image: url(http://i.imgur.com/4a2H5lF.jpg);
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            color: #fff;
            font-family: 'Exo';
            font-size: 12px;
        }
        .asText {
            background:none;
            border:none;
            margin:0;
            padding:0;
            color: #fff;
            font-family: 'Exo';
            font-size: 15px;
            font-weight: bold;
        }
    </style>

</head>
<body>
Welcome ${currentUser.firstname}
<br>${currentUser.city}
    <form role = "logout" method="POST" >
        <button class = "asText" onclick="form.action='logout'">Log Out </button>
    </form>
<hr>

<c:forEach var="event" items="${eventList}" >
    <form role = "eventReservation" method="POST" name = "${event.id}">
        <table>
        <span><p style ="font-size:20px" style="font-weight:bold"> <c style="color:lawngreen">${event.name}</c></p></span>
            <tr>
                <td>Currently Attending: ${event.getNumParticipants()}</td>
            </tr>
            <tr>
                <td>Spots Available: ${event.getCapacity() - event.getNumParticipants()}</td>
            </tr>
                 <td><input type="hidden" name="userid" value="${currentUser.id}"/>
                     <input type="hidden" name="eventid" value="${event.id}"/>
                     <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block"
                             onclick="form.action='eventRsvp'">RSVP</button></td>
        </table>
    </form>
</c:forEach>

<%--<a class = "btn btnPrimary" href="<c:url value='/eventCreate' />"> <i class="fa fa-edit fa-fw"></i>Create Event</a>--%>

</body>
</html>
