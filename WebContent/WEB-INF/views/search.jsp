<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

	<form method="get" action="search">
	
	<input type="text" name="keyword"/>
	<input type="submit" value="Search">
	
	</form>
	
	<c:forEach var="album" items="${ albums }">

			<li><a href="album?id=${ album.id }"> <c:out
						value="${ album.getName() }" />


			</a></li>

		</c:forEach>


	</ul>
	

</body>
</html>