<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events near you</title>
    <style>
        @import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
        body{
            margin: 0;
            padding: 0;
            background-image: url(http://asummerwasting.org/p/soccer.fields.night-2006.jpg);
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            color: #fff;
            font-family: 'Exo';
            font-size: 12px;
        }

    </style>

</head>
<body>
Events near you
<hr>

<c:forEach var="event" items="${eventList}" >
    <table>
    <span><p style ="font-size:20px" style="font-weight:bold"> <c style="color:lawngreen">${event.name}</c></p></span>
        <tr>
            <td>Currently Attending: ${event.numParticipants}</td>
        </tr>
        <tr>
            <td>Spots Available: ${event.capacity - event.numParticipants}</td>
        </tr>
    <td><form action="confirmation" method="POST"><input type="hidden" name="tempId" value="${event.getId()}"/>
    <input type = "submit" name = "rsvp" value="RSVP" /></form></td>
        </table>
</c:forEach>

<%--<a class = "btn btnPrimary" href="<c:url value='/eventCreate' />"> <i class="fa fa-edit fa-fw"></i>Create Event</a>--%>

</body>
</html>
