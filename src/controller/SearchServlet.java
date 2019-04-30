package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.AlbumDao;
import model.Album;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	private AlbumDao albumDao = new AlbumDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. Get requested keyword
		
		String keyword = req.getParameter("keyword");
		
		//2. Search the albums
		
		List<Album> albums = albumDao.findAlbumsByTitle(keyword);
		
		//3.Set the album into parameter
		
		req.setAttribute("albums", albums);
		
		//4. Display results
		
		req.getRequestDispatcher("WEB-INF/views/search.jsp").include(req, resp);
		
	}



}
