package database.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Track;

import database.dao.ChinookDatabase;
import model.Album;

public class TrackDao {
    private ChinookDatabase db = new ChinookDatabase();

    public List<Track> getTracksByAlbum(Album album) {
        // TODO: Get tracks from the database
        return new ArrayList<Track>();
    }
}