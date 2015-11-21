<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%-- Css Plugins--%>
    <link href='<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" />' rel="stylesheet">
    <link href='<c:url value="/resources/dist/css/sb-admin-2.css" />' rel="stylesheet">
    <link href='<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css"/>' rel="stylesheet"
          type="text/css"/>


</head>
<body>
Dashboard
<hr>

<c:forEach var="event" items="${eventList}" >
    <span>${event.name}</span>
</c:forEach>

<%--<a class = "btn btnPrimary" href="<c:url value='/eventCreate' />"> <i class="fa fa-edit fa-fw"></i>Create Event</a>--%>

</body>
</html>
