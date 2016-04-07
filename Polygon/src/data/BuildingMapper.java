	package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuildingMapper {
	//returns a list of ALL buildings from the database.
	public ArrayList<Building> getBuildings() throws SQLException {
		ArrayList<Building> result = new ArrayList<>();

		String SQLString = "SELECT * FROM Buildings;";

		PreparedStatement statement = Connector.prepare(SQLString);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			int building_id = rs.getInt(1);
			int organisation_id = rs.getInt(2);
			String building_name = rs.getString(3);
			String street_address = rs.getString(4);
			int zip = rs.getInt(5);
			int build_year = rs.getInt(6);
			int floor_area = rs.getInt(7);

			result.add(new Building(building_id, organisation_id, building_name, street_address, zip, build_year, floor_area));
		}
		Connector.cleanUp(statement, rs);
		return result;
	}
	//adds a NEW building to the database. (consider adding organisation to Building object at a higher layer)
	public void createBuilding(Building b, int organisation_id) throws SQLException {

		String SQLString = "INSERT INTO buildings (organisations_id, building_name, street_address, zipcode, build_year, floor_area) VALUES (?,?,?,?,?,?)";

		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setInt(1, organisation_id);
		statement.setString(2, b.getBuilding_name());
		statement.setString(3, b.getStreet_address());
		statement.setInt(4, b.getZip());
		statement.setInt(5, b.getBuild_year());
		statement.setInt(6, b.getFloor_area());

		statement.executeUpdate();
	}
	//returns a list of Buildings belonging to a SPECIFIC USER (consider using User object as parameter)
	//(consider handling this logic at a higher layer. getBuildings() -> then extract Buildings belonging to user)
	public ArrayList<Building> getUserBuildings(int user_id) throws SQLException {
		ArrayList<Building> result = new ArrayList<>();

		String SQLString = "select building_id,organisations_id,building_name,street_address,zipcode,build_year,floor_area from buildings natural join users where organisations_id=(select organisations_id from users where user_id=?);";

		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setInt(1, user_id);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			int building_id = rs.getInt(1);
			int organisation_id = rs.getInt(2);
			String building_name = rs.getString(3);
			String street_address = rs.getString(4);
			int zip = rs.getInt(5);
			int build_year = rs.getInt(6);
			int floor_area = rs.getInt(7);

			result.add(new Building(building_id, organisation_id, building_name, street_address, zip, build_year, floor_area)); 
		}
		Connector.cleanUp(statement, rs);
		return result;
	}
	//removes a user from the database. (consider using User as parameter instead)
	public void deleteBuilding(int id) throws SQLException {

		String SQLString = "DELETE FROM Buildings WHERE building_id = ?";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, id);

		statement.executeUpdate();

	}

}
