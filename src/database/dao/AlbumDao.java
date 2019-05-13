package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.dao.ChinookDatabase;
import model.Album;
import model.Artist;

public class AlbumDao {
	private ChinookDatabase db = new ChinookDatabase();

	public Album findAlbum(long id) {
		Connection conn = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			statement = conn.prepareStatement(
					"SELECT *, (SELECT COUNT(*) FROM Track WHERE AlbumId = Album.AlbumId) AS TrackCount, "
							+ "(SELECT SUM(Milliseconds) FROM Track WHERE AlbumId = Album.AlbumId) AS Milliseconds "
							+ "FROM Album " + "WHERE AlbumId = ?");
			statement.setLong(1, id);
			results = statement.executeQuery();

			if (results.next()) {
				String title = results.getString("Title");
				long albumId = results.getLong("AlbumId");
				long artistId = results.getLong("ArtistId");
				long trackCount = results.getLong("TrackCount");
				long milliseconds = results.getLong("Milliseconds");

				return new Album(albumId, title, artistId, trackCount, milliseconds);
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}
	}

	public List<Album> findAlbumsByArtist(Artist artist) {
		Connection conn = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;

		List<Album> albums = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT AlbumId, Title, ArtistId, "
					+ "(SELECT COUNT(*) FROM Track WHERE AlbumId = Album.AlbumId) AS TrackCount, "
					+ "(SELECT SUM(Milliseconds) FROM Track WHERE AlbumId = Album.AlbumId) AS Milliseconds "
					+ "FROM Album " + "WHERE ArtistId = ?");
			statement.setLong(1, artist.getId());

			results = statement.executeQuery();

			while (results.next()) {
				long id = results.getLong("AlbumId");
				String title = results.getString("Title");
				long artistId = results.getLong("ArtistId");
				long trackCount = results.getLong("TrackCount");
				long milliseconds = results.getLong("Milliseconds");

				albums.add(new Album(id, title, artistId, trackCount, milliseconds));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}

		return albums;
	}

	public List<Album> searchAlbumsByTitle(String keyword) {
		Connection conn = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;

		List<Album> albums = new ArrayList<>();

		try {
			statement = conn.prepareStatement(
					"SELECT *, " + "(SELECT COUNT(*) FROM Track WHERE AlbumId = Album.AlbumId) AS TrackCount, "
							+ "(SELECT SUM(Milliseconds) FROM Track WHERE AlbumId = Album.AlbumId) AS Milliseconds "
							+ "FROM Album " + "WHERE Title LIKE ?");
			statement.setString(1, "%" + keyword + "%");

			results = statement.executeQuery();

			while (results.next()) {
				long id = results.getLong("AlbumId");
				String title = results.getString("Title");
				long artistId = results.getLong("ArtistId");
				long trackCount = results.getLong("TrackCount");
				long milliseconds = results.getLong("Milliseconds");

				albums.add(new Album(id, title, artistId, trackCount, milliseconds));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}

		return albums;
	}
}
