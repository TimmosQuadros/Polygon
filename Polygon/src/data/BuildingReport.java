package data;

import java.util.ArrayList;

import org.apache.tomcat.jni.File;

public class BuildingReport {
	
	private int reportID;
	private int buildingID;
	private String roofRemark;
	private File roofImage;
	private String outerWallRemark;
	private File outerWallImage;
	private ArrayList<RoomReport> roomReports;
	private ArrayList<RoomConclusion> roomConclusion;
	private int technicianID;
	private String facilityManagerName;
	public enum BuildingCondition {CONDITION0,CONDITION1,CONDITION2,CONDITION3}
	
	public BuildingReport(int reportID, int buildingID, String roofRemark, File roofImage, String outerWallRemark,
			File outerWallImage, ArrayList<RoomReport> roomReports, ArrayList<RoomConclusion> roomConclusion,
			int technicianID, String facilityManagerName) {
		super();
		this.reportID = reportID;
		this.buildingID = buildingID;
		this.roofRemark = roofRemark;
		this.roofImage = roofImage;
		this.outerWallRemark = outerWallRemark;
		this.outerWallImage = outerWallImage;
		this.roomReports = roomReports;
		this.roomConclusion = roomConclusion;
		this.technicianID = technicianID;
		this.facilityManagerName = facilityManagerName;
	}

	public int getReportID() {
		return reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public int getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	public String getRoofRemark() {
		return roofRemark;
	}

	public void setRoofRemark(String roofRemark) {
		this.roofRemark = roofRemark;
	}

	public File getRoofImage() {
		return roofImage;
	}

	public void setRoofImage(File roofImage) {
		this.roofImage = roofImage;
	}

	public String getOuterWallRemark() {
		return outerWallRemark;
	}

	public void setOuterWallRemark(String outerWallRemark) {
		this.outerWallRemark = outerWallRemark;
	}

	public File getOuterWallImage() {
		return outerWallImage;
	}

	public void setOuterWallImage(File outerWallImage) {
		this.outerWallImage = outerWallImage;
	}

	public ArrayList<RoomReport> getRoomReports() {
		return roomReports;
	}

	public void setRoomReports(ArrayList<RoomReport> roomReports) {
		this.roomReports = roomReports;
	}

	public ArrayList<RoomConclusion> getRoomConclusion() {
		return roomConclusion;
	}

	public void setRoomConclusion(ArrayList<RoomConclusion> roomConclusion) {
		this.roomConclusion = roomConclusion;
	}

	public int getTechnicianID() {
		return technicianID;
	}

	public void setTechnicianID(int technicianID) {
		this.technicianID = technicianID;
	}

	public String getFacilityManagerName() {
		return facilityManagerName;
	}

	public void setFacilityManagerName(String facilityManagerName) {
		this.facilityManagerName = facilityManagerName;
	};
	
	
	
}
