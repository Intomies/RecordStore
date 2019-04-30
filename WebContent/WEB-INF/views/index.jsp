<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record Store / All Artists</title>
</head>
<body>

	<h1>Welcome</h1>
	
	<form method="get" action="search">
	
	<input type="text" name="keyword"/>
	<input type="submit" value="Search">
	
	</form>

	<ul>

		<c:forEach var="artist" items="${ artists }">

			<li><a href="artist?id=${ artist.id }"> <c:out
						value="${ artist.getName() }" />


			</a></li>

		</c:forEach>


	</ul>

</body>
</html>