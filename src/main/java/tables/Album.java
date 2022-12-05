package tables;

import java.sql.*;

public class Album {
	private int idno; //PRIMARY KEY
	private String title; //title of album
	private Date copyright_date; //date of when album was created
	private String format; //what type of album is it?
	private int album_id; //FOREIGN KEY REFERENCES ALBUMS
	private int prod_ssn; //FOREIGN KEY REFERENCES MUSICIANS - producer of album
	
	//Getters and Setters for data
	public int getIdno() {
		return idno;
	}
	public void setIdno(int idno) {
		this.idno = idno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCopyright_date() {
		return copyright_date;
	}
	public void setCopyright_date(Date copyright_date) {
		this.copyright_date = copyright_date;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public int getProd_ssn() {
		return prod_ssn;
	}
	public void setProd_ssn(int prod_ssn) {
		this.prod_ssn = prod_ssn;
	}  
}