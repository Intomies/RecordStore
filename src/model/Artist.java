package model;

public class Artist {
	
	public long id;
	public String name;
	
	public Artist (long id, String name) {
		
		this.id = id;
		this.name = name;
		
	}

	
	  public long getId() { 
		  
		  return id; }
	 

	public String getName() {
		return name;
	}
	
	@Override

	public String toString() {
		
		return this.name + " " + this.id;
		
	}
	
	
}


