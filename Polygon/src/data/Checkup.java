package data;

public class Checkup {
	
	private int checkupID, buildingID, customerID, techID;
	private String dateIssued, dateProcessed;
	public enum OrderStatus {PENDING, FINISHED, CANCELLED, PROGRESSING};
	private OrderStatus status;
	public Checkup(int buildingID, int customerID, int techID, String dateIssued) {
		super();
		this.buildingID = buildingID;
		this.customerID = customerID;
		this.techID = techID;
		this.dateIssued = dateIssued;
		this.status = OrderStatus.valueOf("PENDING");
	}
	
	public Checkup(int checkupID, int buildingID, int customerID, int techID, String dateIssued, String dateProcessed,
			OrderStatus status) {
		super();
		this.checkupID = checkupID;
		this.buildingID = buildingID;
		this.customerID = customerID;
		this.techID = techID;
		this.dateIssued = dateIssued;
		this.dateProcessed = dateProcessed;
		this.status = status;
	}

	public int getCheckupID() {
		return checkupID;
	}
	public void setCheckupID(int checkupID) {
		this.checkupID = checkupID;
	}
	public int getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getTechID() {
		return techID;
	}
	public void setTechID(int techID) {
		this.techID = techID;
	}
	public String getDateIssued() {
		return dateIssued;
	}
	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}
	public String getDateProcessed() {
		return dateProcessed;
	}
	public void setDateProcessed(String dateProcessed) {
		this.dateProcessed = dateProcessed;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	
	
}
