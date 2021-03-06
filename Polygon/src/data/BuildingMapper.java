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
	public void createBuilding(Building b, int organisation_id) throws SQLException{

		String SQLString = "INSERT INTO buildings (organisations_id, building_name, street_address, zipcode, build_year, floor_area) VALUES (?,?,?,?,?,?)";

		PreparedStatement statement = Connector.prepare(SQLString);

		checkBuildingData(b);


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
	public ArrayList<Building> getUserBuildings(int organisations_id) throws SQLException {
		ArrayList<Building> result = new ArrayList<>();

		String SQLString = "select * from buildings where organisations_id = ?;";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, organisations_id);

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

	public int getMaxBuildingId() throws SQLException{
		String SQLString = "select max(building_id) from buildings;";

		PreparedStatement statement = Connector.prepare(SQLString);

		ResultSet resultSet = statement.executeQuery();

		int result;

		resultSet.next();

		result=resultSet.getInt(1);

		return result;
	}

	//replaces a Building in the database. retrieve Building -> change attribute(s) -> use this method.
	public void updateBuilding(Building b) throws SQLException {

		String SQLString = "UPDATE buildings SET organisations_id = ?, building_name = ?, street_address = ?, zipcode = ?, build_year = ?, floor_area = ? WHERE building_id = ?";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, b.getOrganisation_id());
		statement.setString(2, b.getBuilding_name());
		statement.setString(3, b.getStreet_address());
		statement.setInt(4, b.getZip());
		statement.setInt(5, b.getBuild_year());
		statement.setInt(6, b.getFloor_area());
		statement.setInt(7, b.getBuilding_id());

		statement.executeUpdate();
	}

	//removes a user from the database. (consider using User as parameter instead)
	public void deleteBuilding(int id) throws SQLException {

		String SQLString = "DELETE FROM Buildings WHERE building_id = ?";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, id);

		statement.executeUpdate();

	}

	public boolean checkStringForNumbers(String s){
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || s.charAt(i)=='3' || s.charAt(i)=='4' || s.charAt(i)=='5' || s.charAt(i)=='6' || s.charAt(i)=='7' || s.charAt(i)=='8' || s.charAt(i)=='9'){
				return false;
			}
		}
		return true;
	}

	public boolean checkStringForLetters(String s){
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || s.charAt(i)=='3' || s.charAt(i)=='4' || s.charAt(i)=='5' || s.charAt(i)=='6' || s.charAt(i)=='7' || s.charAt(i)=='8' || s.charAt(i)=='9'){

			}else {
				return false;
			}
		}
		return true;
	}

	public void checkBuildingData(Building b){
		if(b.getBuilding_name().length()>32){
			throw new NumberFormatException();
		}else if (b.getStreet_address().length()>64){
			throw new NumberFormatException();
		}else if(String.valueOf(b.getZip()).length()!=4 || !checkStringForLetters(String.valueOf(b.getZip()))){
			throw new NumberFormatException();
		}else if(String.valueOf(b.getBuild_year()).length()!=4 || !checkStringForLetters(String.valueOf(b.getBuild_year()))){
			throw new NumberFormatException();
		}else if(String.valueOf(b.getFloor_area()).length()>8 || !checkStringForLetters(String.valueOf(b.getFloor_area()))){
			throw new NumberFormatException();
		}
	}

}
