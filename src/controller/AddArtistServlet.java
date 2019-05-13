package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.ArtistDao;
import model.Artist;

@WebServlet("/artist/add")

public class AddArtistServlet extends HttpServlet {

	private ArtistDao artistDao = new ArtistDao();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/addArtist.jsp");
		dispatcher.include(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String artistName = req.getParameter("artistName");

		if (artistName == null || "".equals(artistName)) {

			req.setAttribute("error", "No name given");
			doGet(req, resp);

		} else {

			Artist artist = new Artist(0, artistName, 0);
			artistDao.addArtist(artist);
			resp.sendRedirect("/RecordStore/artist?id=" + artist.getId());

		}

	}

}