package tables;

public class Instrument {
	private int insid; //PRIMARY KEY
	private String name; //name of instrument
	private String music_key; //names of the music keys
	private int mus_ssn; //FOREIGN KEY REFERENCES MUSICIANS
	
	//Getters and Setters for data
	public int getInsid() {
		return insid;
	}
	public void setInsid(int insid) {
		this.insid = insid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMusic_key() {
		return music_key;
	}
	public void setMusic_key(String music_key) {
		this.music_key = music_key;
	}
	public int getMus_ssn() {
		return mus_ssn;
	}
	public void setMus_ssn(int mus_ssn) {
		this.mus_ssn = mus_ssn;
	}
}