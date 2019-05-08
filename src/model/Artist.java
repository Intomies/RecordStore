package model;

public class Artist {

	private long id;
	private String name;
	private long albumCount;

	public Artist(long id, String name, long albumCount) {

		this.id = id;
		this.name = name;
		this.albumCount = albumCount;
	}

	public long getId() {

		return this.id;

	}

	public String getName() {
		return this.name;
	}

	public long getAlbumCount() {

		return this.albumCount;

	}

}
