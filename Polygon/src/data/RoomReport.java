package data;

import java.util.ArrayList;

public class RoomReport {

	int room_report_id, building_report_id;

	String room_name, damage_reperation, moisture_scan;

	ArrayList<RoomReportImage> roomReportImage = new ArrayList<>();

	public RoomReport(int room_report_id, int building_report_id, String room_name, String damage_reperation,
			String moisture_scan, ArrayList<RoomReportImage> roomReportImage) {
		super();
		this.room_report_id = room_report_id;
		this.building_report_id = building_report_id;
		this.room_name = room_name;
		this.damage_reperation = damage_reperation;
		this.moisture_scan = moisture_scan;
		
	}

	public int getRoom_report_id() {
		return room_report_id;
	}

	public void setRoom_report_id(int room_report_id) {
		this.room_report_id = room_report_id;
	}

	public int getBuilding_report_id() {
		return building_report_id;
	}

	public void setBuilding_report_id(int building_report_id) {
		this.building_report_id = building_report_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getDamage_reperation() {
		return damage_reperation;
	}

	public void setDamage_reperation(String damage_reperation) {
		this.damage_reperation = damage_reperation;
	}

	public String getMoisture_scan() {
		return moisture_scan;
	}

	public void setMoisture_scan(String moisture_scan) {
		this.moisture_scan = moisture_scan;
	}

}
