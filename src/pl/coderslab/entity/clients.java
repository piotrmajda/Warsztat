package pl.coderslab.entity;

public class clients {
	private int id;
	private String name;
	private String surname;
	private String mail;
	private int phone;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getMail() {
		return mail;
	}
	public int getPhone() {
		return phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public clients(int id, String name, String surname, String mail, int phone) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.phone = phone;
	}
	

}
