<%--Tag Library for jsp--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Event Creation Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<form role="create new event" method="POST">
    <h1>Post New Game</h1>
    <fieldset class="row1">
        <legend>Venue Details
        </legend>
        <p>
            <label>Location name
            </label>
            <input type ="text" name="name" required/>
        </p>
        <p>
            <label>Street Address
            </label>
            <input type ="text" name="address" required/>
        </p>
        <p>
            <label>City
            </label>
            <input type="text" name="city" required/>
        </p>
        <p>
            <label>Country
            </label>
            <input type="text" name="country" required/>
        </p>
        <p>
            <label>Postal Code
            </label>
            <input type="text" name="postalCode" />
        </p>
    </fieldset>
    <fieldset class="row2">
        <legend>Game Details
        </legend>
        <p>
            <label>Date
            </label>
            <input type="datetime-local" class="long" name = "date"/>
        </p>
        <p>
            <label>Game type
            </label>
            <input type="text" name = "type"/>
        </p>
        <p>
            <label>Capacity
            </label>
            <input type="text" name = "capacity"/>
            <input type="hidden" name = "numParticipants" value = "0"/>
        </p>
        <p>
            <label>Min Age
            </label>
            <input type="text" name = "minimumAge"/>
        </p>
        <p>
            <label>Max Age
            </label>
            <input type="text" name = "maximumAge"/>
        </p>
        <p>
            <label>Gender</label>
            <table>
        <td>Male <input type="radio" name = "gender" value="Male"/></td>
        <td>Female <input type="radio" name = "gender" value="Female"/></td>
        <td>Mixed <input type="radio" name = "gender" value="Mixed"/></td>
            </table>
        </p>
        <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block"
                onclick="form.action='eventCreateSubmit'">Submit</button>
        <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block"
                onclick="form.action='adminPage'">Cancel</button>
    </fieldset>
</form>
</body>
</html>