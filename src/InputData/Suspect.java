package InputData;

public class Suspect {
	
	int id;
	String adn;
	
	public Suspect(int id, String adn) {
		this.id = id;
		this.adn = adn;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdn() {
		return adn;
	}
	public void setAdn(String adn) {
		this.adn = adn;
	}
	
	@Override
	public String toString() {
		return "Suspect [id=" + id + ", adn=" + adn + "]";
	}
}
