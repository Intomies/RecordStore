<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<jsp:include page="_head.jsp">
	<jsp:param name="title" value="${ album.getTitle() }" />
</jsp:include>

<body>
	
	<h1>Gregords Inc.</h1>

	<%-- The form could be included from another file with jsp:include tag --%>

	<jsp:include page="_searchForm.jsp" />
	
	</form>

	<h1>
		<c:out value="${ album.getTitle() }" />
	</h1>
	<h2>
		Album by
		<c:out value="${ artist.getName() }" />
	</h2>

<!-- Table Starts: -->

	<table>

		<thead>
			<tr>
				<th>#</th>
				<th>Track Name</th>
				<th>Length</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="track" items="${ tracks }" varStatus="loop">

				<tr>

					<td><c:out value="${ loop.index + 1 }" /></td>

					<td><c:out value="${ track.getName() }" /></td>

					<td><c:out value="${ track.getTime() }" /></td>

				</tr>

			</c:forEach>
		</tbody>

	</table>

</body>
</html>