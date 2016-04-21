package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomReportMapper {
	
	public void createRoomReport(RoomReport r) throws SQLException{
		String SQLString = "INSERT INTO room_report (building_report_id,room_name,damage_reperation,moisture_scan) VALUES (?,?,?,?);";
		
		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, r.getBuilding_report_id());
		statement.setString(2, r.room_name);
		statement.setString(3, r.damage_reperation);
		statement.setString(4, r.getMoisture_scan());
		
		statement.executeUpdate();
	}

	public ArrayList<RoomReport> getRoomReports(int building_report_report_id) throws SQLException{

		String SQLString = "select * from room_report where building_report_report_id=?;";
		PreparedStatement statement = Connector.prepare(SQLString);
		statement.setInt(1, building_report_report_id);
		ResultSet rs = statement.executeQuery();

		ArrayList<RoomReport> roomReports = new ArrayList<>();

		while (rs.next()) {

			int room_report_id = rs.getInt(1);
			int building_report_id = rs.getInt(2);
			String room_name = rs.getString(3);
			String damage_reperation = rs.getString(4);
			String moisture_scan = rs.getString(5);

			roomReports.add(new RoomReport(room_report_id, building_report_id, room_name, damage_reperation, moisture_scan, null));
			

		}
		return roomReports;


	}

//	public getRoomDescription(){
//
//	}
//
//	public getWhatIsDamaged(){
//
//	}
//	
//	public whatIsRepaired(){
//		
//	}

}
