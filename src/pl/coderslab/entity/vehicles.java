package pl.coderslab.entity;

public class vehicles {
	private int id;
	private String brand;
	private String model;
	private int prodYear;
	private String regNum;
	private String nextService;
	private int clientId;
	public vehicles(int id, String brand, String model, int prodYear, String regNum, String nextService, int clientId) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.prodYear = prodYear;
		this.regNum = regNum;
		this.nextService = nextService;
		this.clientId = clientId;
	}
	public vehicles(String brand, String model, int prodYear, String regNum, String nextService, int clientId) {
		super();
		this.brand = brand;
		this.model = model;
		this.prodYear = prodYear;
		this.regNum = regNum;
		this.nextService = nextService;
		this.clientId = clientId;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public int getProdYear() {
		return prodYear;
	}
	public String getRegNum() {
		return regNum;
	}
	public String getNextService() {
		return nextService;
	}
	public int getClientId() {
		return clientId;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setProdYear(int prodYear) {
		this.prodYear = prodYear;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	public void setNextService(String nextService) {
		this.nextService = nextService;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	

}
