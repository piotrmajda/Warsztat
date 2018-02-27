package pl.coderslab.entity;

public class employees {
	private int id;
	private String name;
	private String surname;
	private String address;
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

	public String getAddress() {
		return address;
	}

	public int getPhone() {
		return phone;
	}

	public String getNote() {
		return note;
	}

	public double getEmployee_hours() {
		return employee_hours;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setEmployee_hours(double employee_hours) {
		this.employee_hours = employee_hours;
	}

	private String note;
	private double employee_hours;
	
	public employees(int id, String name, String surname, String address, int phone, String note,
			double employee_hours) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.note = note;
		this.employee_hours = employee_hours;
	}
	
}
