package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuildingMapper {

	ArrayList<Building> getBuildings() throws SQLException {
		ArrayList result = new ArrayList<>();
		
		String SQLString = "SELECT * FROM Buildings;";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			
			String building_name = rs.getString(2);
			String street_address = rs.getString(3);
			int building_id = rs.getInt(1);
			int zip = rs.getInt(4);
			
			result.add(new Building(building_name, street_address, building_id, zip));
		}
		
		return result;
	}
	
}
