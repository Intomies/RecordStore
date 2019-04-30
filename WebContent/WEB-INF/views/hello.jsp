<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
</head>
<body>

<!-- Html style comment, shows in html code -->
<%-- JSP style comment, doesn't show in html code  --%>

<h1>Hello <c:out value="${ param.firstname }" /></h1>
<h2>${ 1 + 2 + 3 + 4 }</h2>

</body>
</html>