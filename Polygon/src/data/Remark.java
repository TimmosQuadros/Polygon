package data;

import java.io.Serializable;

public class Remark implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int remarkId;
	private int roomReportId;
	private String description;
	private String type;
	
	public Remark(int remarkId, int roomReportId, String description, String type) {
		super();
		this.remarkId = remarkId;
		this.roomReportId = roomReportId;
		this.description = description;
		this.type = type;
	}
	public int getRemarkiId() {
		return remarkId;
	}
	public void setRemarkiId(int remarkiId) {
		this.remarkId = remarkiId;
	}
	public int getRoomReportId() {
		return roomReportId;
	}
	public void setRoomReportId(int roomReportId) {
		this.roomReportId = roomReportId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	
}
