<%--Tag Library for jsp--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Edit User Information</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<form role="create new user" method="POST">
    <h1>Change your information</h1>
    <fieldset class="row1">
        <legend>Account Details
        </legend>
        <p>
            <label>Password
            </label>
            <input type="password" name="password" required/>
        </p>
    </fieldset>
    <fieldset class="row2">
        <legend>Personal Details
        </legend>
        <p>
            <label class="optional">Street Address
            </label>
            <input type="text" class="long" name = "address"/>
        </p>
        <p>
            <label>City
            </label>
            <input type="text" class="long" name = "city"/>
        </p>
        <p>
            <label>Country
            </label>
            <input type="text" class="long" name = "country"/>
        </p>
        <p>
            <label>Postal Code
            </label>
            <input type="text" class="long" name = "postalcode" maxlength = "7"/>
        </p>
    </fieldset>

        <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block"
                onclick="form.action='editUserSubmit'">Submit</button>
</form>
</body>
</html>