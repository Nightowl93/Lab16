package co.grandcircus.lab16;

public class Country {
	private String name;
	private String continent;
	boolean visited;
	
	public Country(String name, String continent, boolean visited) {
		this.name = name;
		this.continent = continent;
		this.visited = visited;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return name + "++" + continent + "++" + visited;
	}
	
	

}
