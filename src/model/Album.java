package model;

public class Album {
	
	private long id;
	private String title;
	
	
	public Album (long id, String album) {
		
		this.id = id;
		this.title = album;
		
		
	}
	
	
	public String getTitle() {
		return title;
	}

}
