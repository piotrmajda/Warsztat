package pl.coderslab.entity;

public class orders {
	private int id;
	private String orderDate;
	private String startDate;
	private int employeeId;
	private String problemDesc;
	private String repairDesc;
	private int vehicleId;
	private double generalCost;
	private double partsCost;
	private double employeeHours;
	private double employeeHourlyRate;
	private int clientId;
	private String plannedStartDate;
	private String status;
	
	
	public orders(int id, String orderDate, String startDate, int employeeId, String problemDesc, String repairDesc,
			int vehicleId, double generalCost, double partsCost, double employeeHours, double employeeHourlyRate,
			int clientId, String plannedStartDate, String status) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.startDate = startDate;
		this.employeeId = employeeId;
		this.problemDesc = problemDesc;
		this.repairDesc = repairDesc;
		this.vehicleId = vehicleId;
		this.generalCost = generalCost;
		this.partsCost = partsCost;
		this.employeeHours = employeeHours;
		this.employeeHourlyRate = employeeHourlyRate;
		this.clientId = clientId;
		this.plannedStartDate = plannedStartDate;
		this.status = status;
	}
	public orders(String orderDate, String startDate, int employeeId, String problemDesc, String repairDesc,
			int vehicleId, double generalCost, double partsCost, double employeeHours, double employeeHourlyRate,
			int clientId, String plannedStartDate, String status) {
		super();
		this.orderDate = orderDate;
		this.startDate = startDate;
		this.employeeId = employeeId;
		this.problemDesc = problemDesc;
		this.repairDesc = repairDesc;
		this.vehicleId = vehicleId;
		this.generalCost = generalCost;
		this.partsCost = partsCost;
		this.employeeHours = employeeHours;
		this.employeeHourlyRate = employeeHourlyRate;
		this.clientId = clientId;
		this.plannedStartDate = plannedStartDate;
		this.status = status;
	}

	public orders(String plannedStartDate, int employeeId, String problemDesc, int vehicleId, int clientId, String status) {
		this.plannedStartDate = plannedStartDate;
		this.employeeId = employeeId;
		this.problemDesc = problemDesc;
		this.vehicleId = vehicleId;
		this.clientId = clientId;
		this.status = status;
	}

	public String getPlannedStartDate() {
		return plannedStartDate;
	}

	public String getStatus() {
		return status;
	}

	public void setPlannedStartDate(String plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getProblemDesc() {
		return problemDesc;
	}

	public String getRepairDesc() {
		return repairDesc;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public double getGeneralCost() {
		return generalCost;
	}

	public double getPartsCost() {
		return partsCost;
	}

	public double getEmployeeHours() {
		return employeeHours;
	}

	public double getEmployeeHourlyRate() {
		return employeeHourlyRate;
	}

	public int getClientId() {
		return clientId;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}

	public void setRepairDesc(String repairDesc) {
		this.repairDesc = repairDesc;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setGeneralCost(double generalCost) {
		this.generalCost = generalCost;
	}

	public void setPartsCost(double partsCost) {
		this.partsCost = partsCost;
	}

	public void setEmployeeHours(double employeeHours) {
		this.employeeHours = employeeHours;
	}

	public void setEmployeeHourlyRate(double employeeHourlyRate) {
		this.employeeHourlyRate = employeeHourlyRate;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


}
