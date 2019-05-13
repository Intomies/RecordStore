package database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import model.Album;
import model.Artist;

public class AlbumDaoTest {

	@Test
	public void testSearchingByKeyword() {
		AlbumDao dao = new AlbumDao();

		List<Album> albums = dao.searchAlbumsByTitle("pill");

		assertEquals("Jagged Little Pill", albums.get(0).getTitle());
	}

	@Test
	public void testSearchingWithUnexistingKeyword() {
		AlbumDao dao = new AlbumDao();

		List<Album> albums = dao.searchAlbumsByTitle("XYZ123");

		assertTrue(albums.isEmpty());
	}

	@Test
	public void testSearchingAlbumsByArtist() {
		AlbumDao albumDao = new AlbumDao();
		ArtistDao artistDao = new ArtistDao();

		Artist artist = artistDao.findArtist(1);

		List<Album> albums = albumDao.findAlbumsByArtist(artist);

		assertTrue(albums.size() == 2);

	}
}