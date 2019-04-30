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

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

    private ArtistDao artistDao = new ArtistDao();

    private AlbumDao albumDao = new AlbumDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. Get the artist id from the request:
        String idParameter = request.getParameter("id");
        long id = Long.parseLong(idParameter); // this may fail due to null value or invalid numeric string

        // 2. Load artist from the database (may be null if id does not match)
        Artist artist = artistDao.getArtist(id);

        // 3. Load all albums from the database for the artist
        List<Album> albums = albumDao.getAlbumsByArtist(artist);

        // 4. Print the name of the artist on the response
        response.getWriter().println(artist.getName());

        response.getWriter().println(); // Empty line

        // Print the titles of all albums for the artist
        for (Album album : albums) {
            response.getWriter().println(album.getTitle());
        }
    }
}