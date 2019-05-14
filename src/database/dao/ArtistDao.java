package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.dao.ChinookDatabase;
import model.Artist;

public class ArtistDao {
	private ChinookDatabase db = new ChinookDatabase();
	
	//------------Find Artist by ID:--------------

	public Artist findArtist(long id) {
		Connection conn = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			statement = conn.prepareStatement("SELECT * FROM Artist WHERE ArtistId = ?");
			statement.setLong(1, id);
			results = statement.executeQuery();

			if (results.next()) {
				String name = results.getString("Name");
				long artistId = results.getLong("ArtistId");
				long albumCount = 0;

				return new Artist(artistId, name, albumCount);
			} else {
				return null;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}
	}
	
	//-------------Find All Artists:--------------

	public List<Artist> findAllArtists() {
		Connection conn = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> artists = new ArrayList<>();

		try {
			// 1. Create the SQL statement
			statement = conn.prepareStatement("SELECT ArtistId, Name, "
					+ "(SELECT COUNT(*) FROM Album WHERE ArtistId = Artist.ArtistId) AS AlbumCount " 
					+ "FROM Artist "
					+ "ORDER BY Name");

			// 2. Execute the statement and get results to local variable
			results = statement.executeQuery();

			while (results.next()) {
				// 3. Transform data from DB into Java objects
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");
				long albumCount = results.getLong("AlbumCount");

				Artist a = new Artist(id, name, albumCount);

				// 4. Add each artist to list one-by-one
				artists.add(a);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			// 5. Close all resources
			db.close(results, statement, conn);
		}

		// 6. Return all artists as a list
		return artists;
	}
	
	//----------Find Artists By Name--------------
	
	public List<Artist> findArtistsByName(String name) {

		Connection conn = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> artists = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM Artist WHERE Name = ?");
			statement.setString(1, name);
			results = statement.executeQuery();

			while (results.next()) {

				long id = results.getLong("ArtistId");
				name = results.getString("Name");
				long albumCount = 0;

				Artist a = new Artist(id, name, albumCount);

				artists.add(a);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}

		return artists;
	}
	
	//-------------Search Artists By Keyword-----------------
	
	public List<Artist> searchArtistsByKeyword(String keyword) {
		Connection conn = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;

		List<Artist> artists = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT ArtistId, Name, "
					+ "(SELECT COUNT(*) FROM Album WHERE ArtistId = Artist.ArtistId) AS AlbumCount "
					+ "FROM Artist "
					+ "WHERE Name LIKE ?");
			statement.setString(1, "%" + keyword + "%");

			results = statement.executeQuery();

			while (results.next()) {
				long artistId = results.getLong("ArtistId");
				String name = results.getString("Name");
				long albumCount = results.getLong("AlbumCount");

				artists.add(new Artist(artistId, name, albumCount));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}

		return artists;
	}
	
//	----------------Add new Artist to database-------------------
	
	public void addArtist(Artist artist) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		
		try {
			
			connection = db.connect();
			statement = connection.prepareStatement("INSERT INTO Artist (Name)"
					+ "VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, artist.getName());
			statement.executeUpdate();
			
			generatedKeys = statement.getGeneratedKeys();
			
			if(generatedKeys.next()) {
				
				long id = generatedKeys.getLong(1);
				artist.setId(id);
				
			}
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			
		} finally {
			
			db.close(generatedKeys, statement, connection);
			
		}
		
	}
	
	
}