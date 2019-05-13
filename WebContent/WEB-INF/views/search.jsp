<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<jsp:include page="_head.jsp">
	<jsp:param name="title" value="Search for Artists or Albums" />
</jsp:include>

<body>

	<jsp:include page="_buttons.jsp" />

	<h1>Gregords Inc.</h1>

	<jsp:include page="_searchForm.jsp" />

	<c:if test="${ param.keyword != null }">

		<h2>Search results:</h2>

		<c:if test="${ artists.size() > 0 }">

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
		</c:if>
		<c:if test="${ artists.size() == 0 }">
			<h2>No Artists Found</h2>
		</c:if>
	</c:if>

	<c:if test="${ param.keyword != null }">
		<c:if test="${ albums.size() > 0 }">
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
		</c:if>

		<c:if test="${ albums.size() == 0 }">
			<h2>No Albums Found</h2>
		</c:if>
	</c:if>

</body>
</html>