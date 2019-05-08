<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<jsp:include page="_head.jsp">
	<jsp:param name="title" value="Search results for" />
</jsp:include>

<body>

	<h1>Gregords Inc.</h1>

	<%-- The form could be included from another file with jsp:include tag --%>

	<jsp:include page="_searchForm.jsp" />

	<h2>Search results:</h2>

	<h3>Artists:</h3>

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


	<h3>Albums:</h3>

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

</body>
</html>