<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="_head.jsp">
	<jsp:param name="title" value="Add Artists" />
</jsp:include>
<body>
	
	<jsp:include page="_buttons.jsp" />
	
	<h1>Gregords Inc.</h1>
	
	<h2>Create new Artist</h2>
	
	<c:if test="${ error != null }">
		<h2>Error: <c:out value="${ error }" /></h2>
	</c:if>
	
	<form method="post">
    <label>
        Name: 
        <input name="artistName" />
    </label>
    <input type="submit" value="Save" />
</form>

</body>
</html>