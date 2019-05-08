package model;

public class Track {
	
	private long id;
	private String name;
	private long time;
	
	public Track (long id, String name, long time) {
		
		this.id = id;
		this.name = name;
		this.time = time;
		
			
	}

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public String getTime() {
		
		
		return millisecondsToTime(this.time);
		
	}

	private String millisecondsToTime(long time) {
		
		long mins = (time/1000) / 60;
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
