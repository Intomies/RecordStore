package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.sound.midi.Track;

import database.dao.ChinookDatabase;
import model.Album;
import model.Artist;
import model.Track;

public class TrackDao {
	private ChinookDatabase db = new ChinookDatabase();
	
	//-------------Find all Tracks in an Album using AlbumId and TrackID---------------

	public List<Track> getTracksByAlbum(Album album) {

		Connection conn = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;

		List<Track> tracks = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT TrackId, Name, Milliseconds FROM Track WHERE AlbumId = ?");
			statement.setLong(1, album.getId());

			results = statement.executeQuery();

			while (results.next()) {
				long id = results.getLong("TrackId");
				String name = results.getString("Name");
				long time = results.getLong("Milliseconds");

				tracks.add(new Track(id, name, time));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			db.close(results, statement, conn);
		}

		return tracks;
	}
}