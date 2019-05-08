package database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import model.Album;

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
}