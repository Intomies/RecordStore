package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.ArtistDao;
import model.Artist;

@WebServlet("")

public class IndexServlet extends HttpServlet {
	
	private ArtistDao dao = new ArtistDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		List<Artist> allArtists = dao.getAllArtists();
		//Tulostetaan HTTP-vastaukseen
		
		
		
		req.setAttribute("artists", allArtists);
		
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").include(req, resp);
		
	}

}
