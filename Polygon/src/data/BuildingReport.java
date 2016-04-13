package data;

import java.util.ArrayList;

public class BuildingReport {

	private int report_id, tech_id, building_id;

	private String roof_remark, outer_wall_remark, facility_manager_name;

	public enum BuildingCondition {
		CON0, CON1, CON2, CON3
	};

	private BuildingCondition buildingCondition;
	
	private ArrayList<BuildingReportImage> buildingReportImage = new ArrayList<>();
	private ArrayList<RoomReport> roomReport = new ArrayList<>();
	
	public ArrayList<BuildingReportImage> getBuildingReportImage() {
		return buildingReportImage;
	}

	public void setBuildingReportImage(ArrayList<BuildingReportImage> buildingReportImage) {
		this.buildingReportImage = buildingReportImage;
	}

	public ArrayList<RoomReport> getRoomReport() {
		return roomReport;
	}

	public void setRoomReport(ArrayList<RoomReport> roomReport) {
		this.roomReport = roomReport;
	}

	
	

	public BuildingReport(int report_id, int tech_id, int building_id, String roof_remark, String outer_wall_remark,
			String facility_manager_name, BuildingCondition buildingCondition) {
		super();
		this.report_id = report_id;
		this.tech_id = tech_id;
		this.building_id = building_id;
		this.roof_remark = roof_remark;
		this.outer_wall_remark = outer_wall_remark;
		this.facility_manager_name = facility_manager_name;
		this.buildingCondition = buildingCondition;
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public int getTech_id() {
		return tech_id;
	}

	public void setTech_id(int tech_id) {
		this.tech_id = tech_id;
	}

	public int getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(int building_id) {
		this.building_id = building_id;
	}

	public String getRoof_remark() {
		return roof_remark;
	}

	public void setRoof_remark(String roof_remark) {
		this.roof_remark = roof_remark;
	}

	public String getOuter_wall_remark() {
		return outer_wall_remark;
	}

	public void setOuter_wall_remark(String outer_wall_remark) {
		this.outer_wall_remark = outer_wall_remark;
	}

	public String getFacility_manager_name() {
		return facility_manager_name;
	}

	public void setFacility_manager_name(String facility_manager_name) {
		this.facility_manager_name = facility_manager_name;
	}

	public BuildingCondition getBuildingCondition() {
		return buildingCondition;
	}

	public void setBuildingCondition(BuildingCondition buildingCondition) {
		this.buildingCondition = buildingCondition;
	}

}
