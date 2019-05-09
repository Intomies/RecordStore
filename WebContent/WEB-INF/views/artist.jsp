<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<jsp:include page="_head.jsp">
	<jsp:param name="title" value="Albums by ${ artist.getName() }" />
</jsp:include>

<body>

	<jsp:include page="_buttons.jsp" />

	<h1>Gregords Inc.</h1>

	<%-- The form could be included from another file with jsp:include tag --%>

	

	

	<h2>
		Albums by
		<c:out value="${ artist.getName() }" />
	</h2>

	<c:if test="${ !albums.isEmpty() }">

		<table>

			<thead>
				<tr>
					<th>#</th>
					<th>Album Name</th>
					<th>Tracks</th>
					<th>Playtime</th>

				</tr>
			</thead>

			<tbody>

				<c:forEach var="album" items="${ albums }" varStatus="loop">

					<tr>

						<td><c:out value="${ loop.index + 1 }" /></td>

						<td><a href="album?id=${ album.getId() }"><c:out
									value="${ album.getTitle() }" /> </a></td>

						<td><c:out value="${ album.getTrackCount() }" /></td>

						<td><c:out value="${ album.getTime() }" /></td>

					</tr>

				</c:forEach>
			</tbody>

		</table>

	</c:if>
	<c:if test="${ albums.isEmpty() }">
		<h2>No albums for this artist :(</h2>
	</c:if>


</body>
</html>