package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.AlbumDao;
import database.dao.ArtistDao;
import model.Album;
import model.Artist;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	private AlbumDao albumDao = new AlbumDao();

	private ArtistDao artistDao = new ArtistDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. Get the requested keyword
		String keyword = req.getParameter("keyword");

		// 2. Search for albums
		List<Album> albums = albumDao.searchAlbumsByTitle(keyword);
		List<Artist> artists = artistDao.searchArtistsByKeyword(keyword);

		// 3. Set the albums into a parameter
		req.setAttribute("albums", albums);
		req.setAttribute("artists", artists);

		// 4. Display results in a nice JSP page
		req.getRequestDispatcher("/WEB-INF/views/search.jsp").include(req, resp);
	}
}