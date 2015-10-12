<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%-- Css Plugins--%>
    <link href='<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" />' rel="stylesheet">
    <link href='<c:url value="/resources/dist/css/sb-admin-2.css" />' rel="stylesheet">
    <link href='<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css"/>' rel="stylesheet"
          type="text/css"/>
    <title></title>
</head>
<body>

<div class="container">
    <h2>Event Registration</h2>
    <form class="form-horizontal" role="form" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-2" >Event Title:</label>
            <div class="col-sm-10">
                <input type="input" class="form-control" name="title" placeholder="Enter Title">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" >Event Description:</label>
            <div class="col-sm-10">
                <input type="input" class="form-control" name="description" placeholder="Enter Description">
            </div>
        </div>
        <button type="submit" onclick="form.action='eventCreateSubmit'" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>
