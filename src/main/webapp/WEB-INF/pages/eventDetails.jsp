<%--Tag Library for jsp--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Event Details for ${currentEvent.name}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <style>
        body {
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/dashBoard">FootyFix</a>
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

<form role="Event details">
    <h1>Event Details</h1>
    <fieldset class="row1">
        <legend>Event Location
        </legend>
        <p>Venue Name:  ${currentEvent.name}</p>
        <p>Street Address:  ${currentEvent.address}</p>
        <p>City: ${currentEvent.city}</p>
        <p>Postal Code: ${currentEvent.postalCode}</p>
        <p>Country: ${currentEvent.country}</p>
    </fieldset>
    <fieldset class="row2">
        <legend>Game Details
        </legend>
        <p>Date and Time: ${currentEvent.date}</p>
        <p>Game Type: ${currentEvent.type}</p>
        <p>Age Group: ${currentEvent.minimumAge} to ${currentEvent.maximumAge}</p>
        <p>Gender: ${currentEvent.gender}</p>
        <p>Currently Attending:  ${currentEvent.numParticipants}</p>
        <p>Spots Available: ${currentEvent.capacity-currentEvent.numParticipants}</p>
    </fieldset>
</form>
<hr>
<form name = "confirm" method = POST>
    <input type="hidden" name="userid" value="${currentUser.id}"/>
    <input type="hidden" name="eventid" value="${currentEvent.id}"/>
<button type="submit" href="index.html" class="btn btn-lg btn-success btn-block"
        onclick="form.action='eventRsvp'">Confirm my reservation</button>
    <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block"
            onclick="form.action='dashBoard'">Return</button>
</form>
</body>
</html>
