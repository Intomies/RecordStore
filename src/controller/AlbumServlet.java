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
import database.dao.TrackDao;
import model.Album;
import model.Artist;
import model.Track;

@WebServlet("/album")
public class AlbumServlet extends HttpServlet {

	private AlbumDao albumDao = new AlbumDao();

	private TrackDao trackDao = new TrackDao();

	private ArtistDao artistDao = new ArtistDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  Get the album id from the request:
		String idParameter = req.getParameter("id");
		long id = Long.parseLong(idParameter); // this may fail due to null value or invalid numeric string

		// Load album from the database (may be null if id does not match)

		Album album = albumDao.findAlbum(id);
		
		// Load artistId from album
		
		Artist artist = artistDao.findArtist(album.getArtistId());

		//  Load all Tracks from the database for the album
		List<Track> tracks = trackDao.getTracksByAlbum(album);

		//  Print the name of the track on the response

		// Print the titles of all tracks for the albums

		resp.getWriter().println(); // Empty line

		req.setAttribute("album", album);
		req.setAttribute("tracks", tracks);
		req.setAttribute("artist", artist);

		req.getRequestDispatcher("/WEB-INF/views/album.jsp").include(req, resp);

	}
}