<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="_head.jsp">
	<jsp:param name="title" value="Gregords Inc." />
</jsp:include>
<body>
	
	<jsp:include page="_buttons.jsp" />
	
	<h1>Gregords Inc.</h1>
	
<%-- 	<jsp:include page="_searchForm.jsp" /> --%>
	
	

	

	<table>

		<thead>
			<tr>
				<th>#</th>
				<th>Artist</th>
				<th>Albums</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="artist" items="${ artists }" varStatus="loop">

				<tr>

					<td><c:out value="${ loop.index + 1 }" /></td>

					<td><a href="artist?id=${ artist.getId() }"><c:out
								value="${ artist.getName() }" /></a></td>

					<td><c:out value="${ artist.getAlbumCount() }" /></td>

				</tr>

			</c:forEach>
		</tbody>

	</table>

</body>
</html>