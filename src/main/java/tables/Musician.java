package tables;

public class Musician {
	private int ssn; //PRIMARY KEY
	private String name; //name of musician
	private String phone; //phone number of musician
	private String address; //address of musician - artists can live in the same household
	
	//Getters and Setters for data
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
