package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuildingMapper {

	ArrayList<Building> getBuildings() throws SQLException {
		ArrayList<Building> result = new ArrayList<>();
		
		String SQLString = "SELECT * FROM Buildings;";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			
			int building_id = rs.getInt(1);
			String building_name = rs.getString(2);
			String street_address = rs.getString(3);
			int zip = rs.getInt(4);
			int build_year = rs.getInt(5);
			int floor_area = rs.getInt(6);
			
			result.add(new Building(building_name, street_address, building_id, zip, build_year, floor_area));
		}
		Connector.cleanUp(statement, rs);
		return result;
	}
	
	void createBuilding(Building b) throws SQLException {
		
		String SQLString = "INSERT INTO buildings (building_name, street_address, zipcode, build_year, floor_area) VALUES (?,?,?,?,?)";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setString(1, b.getBuilding_name());
		statement.setString(2, b.getStreet_address());
		statement.setInt(3, b.getZip());
		statement.setInt(4, b.getBuild_year());
		statement.setInt(5, b.getFloor_area());
		
		statement.executeUpdate();
	}
	void deleteBuilding(int id) throws SQLException {
		
		String SQLString = "DELETE FROM Buildings WHERE building_id = ?";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.executeUpdate();
		
	}
	
}
