package tables;

public class Song {
	private String title; //PRIMARY KEY
	private String author; //name of musician
	private int mus_ssn; // FOREIGN KEY REFERENCES MUSICIANS
	private Integer album_id; //FOREIGN KEY REFERENCES ALBUMS - Can be NULL

	// Getters and Setters for data
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getMus_ssn() {
		return mus_ssn;
	}
	public void setMus_ssn(int mus_ssn) {
		this.mus_ssn = mus_ssn;
	}
	public Integer getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(Integer album_id) {
		this.album_id = album_id;
	}
	
}