package model;

public class Album {

	private long id;
	private String title;
	private long artistId;
	private long trackCount;
	private long milliseconds;

	public Album(long id, String title, long artistId, long trackCount, long milliseconds) {

		this.id = id;
		this.title = title;
		this.artistId = artistId;
		this.trackCount = trackCount;
		this.milliseconds = milliseconds;

	}

	public String getTitle() {
		return this.title;
	}

	public long getId() {

		return this.id;

	}

	public long getArtistId() {

		return this.artistId;

	}

	public long getTrackCount() {

		return this.trackCount;

	}

	public String getTime() {

		return millisecondsToTime(this.milliseconds);

	}

	private String millisecondsToTime(long time) {

		long mins = (time / 1000) / 60;
		long secs = (time / 1000) % 60;
		String secString = Long.toString(secs);
		String seconds = "";

		if (secString.length() >= 2) {

			seconds = secString.substring(0, 2);

		} else {

			seconds = "0" + secString;

		}

		return mins + ":" + seconds;
	}

}
