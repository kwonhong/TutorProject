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
    <form role = "eventReservation" method="POST">
        <table>
        <span><p style ="font-size:20px" style="font-weight:bold"> <c style="color:lawngreen">${event.name}</c></p></span>
            <tr>
                <td>Currently Attending: ${event.numParticipants}</td>
            </tr>
            <tr>
                <td>Spots Available: ${event.capacity - event.numParticipants}</td>
            </tr>
                 <td><input type="hidden" name="userid" value="${current.id}"/>
                     <input type="hidden" name="eventid" value="${event.id}"/>
                    <input type = "submit" name = "submit" value="RSVP" onclick="form.action='eventRsvp'"/></td>
        </table>
    </form>
</c:forEach>

<%--<a class = "btn btnPrimary" href="<c:url value='/eventCreate' />"> <i class="fa fa-edit fa-fw"></i>Create Event</a>--%>

</body>
</html>
