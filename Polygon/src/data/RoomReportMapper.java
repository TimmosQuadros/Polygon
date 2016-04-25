package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomReportMapper {
	
	public void createRoomReport(RoomReport r) throws SQLException{
		String SQLString = "INSERT INTO room_report (room_report_id,building_report_id,room_name,damage_reperation,moisture_scan) VALUES (?,?,?,?,?);";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setInt(1, r.getRoom_report_id());
		statement.setInt(2, r.getBuilding_report_id());
		statement.setString(3, r.getRoom_name());
		statement.setString(4, r.getDamage_reperation());
		statement.setString(5, r.getMoisture_scan());
		
		statement.executeUpdate();
	}

	public ArrayList<RoomReport> getRoomReports() throws SQLException{

		String SQLString = "select * from room_report;";
		PreparedStatement statement = Connector.prepare(SQLString);
		ResultSet rs = statement.executeQuery();

		ArrayList<RoomReport> roomReports = new ArrayList<>();

		while (rs.next()) {

			int room_report_id = rs.getInt(1);
			int building_report_id = rs.getInt(2);
			String room_name = rs.getString(3);
			String damage_reperation = rs.getString(4);
			String moisture_scan = rs.getString(5);

			roomReports.add(new RoomReport(room_report_id, building_report_id, room_name, damage_reperation, moisture_scan));
			

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
