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
    <title>${currentUser.firstname}'s Page</title>
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

<form role="User Profile" method = "POST">
    <h1>Account Details</h1>
    <fieldset class="row1">
        <legend>Account Details
        </legend>
        <p>User Name:  ${currentUser.username}</p>
        <p>E-mail:  ${currentUser.email}</p>
    </fieldset>
    <fieldset class="row2">
        <legend>Personal Details
        </legend>
        <p>First Name:  ${currentUser.firstname}</p>
        <p>Last Name:  ${currentUser.lastname}</p>
        <p>Street Address:  ${currentUser.address}</p>
        <p>City:  ${currentUser.city}</p>
        <p>Country:  ${currentUser.country}</p>
        <p>Postal Code:  ${currentUser.postalcode}</p>
        <p>Gender:  ${currentUser.gender}</p>
        <p>Age:  ${currentUser.age}</p>
    </fieldset>
    <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block"
            onclick="form.action='editInfo'">Edit Profile</button>
</form>

</body>
<hr>
<legend>Your Reservations
</legend>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Event Name</th>
        <th>Street Address</th>
        <th>City</th>
        <th>Date</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="event" items="${reservedList}">
        <tr>
            <form role="eventReservation" method="POST" name="${event.id}">
                <td>${event.name}</td>
                <td>${event.address}</td>
                <td>${event.city}</td>
                <td>${event.date}</td>
                <input type="hidden" name="userid" value="${currentUser.id}"/>
                <input type="hidden" name="eventid" value="${event.id}"/>
                <td>
                    <button type="submit" href="index.html" class="btn btn-sm" onclick="form.action='yourEvent'">
                        View Details
                    </button>
                    <button type="submit" href="index.html" class="btn btn-sm" onclick="form.action='cancelRsvp'">
                        Cancel Reservation
                    </button>
                </td>
            </form>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form name = "goback" method = "POST">
    <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block" onClick="form.action='dashBoard'">Return</button>
</form>
</html>