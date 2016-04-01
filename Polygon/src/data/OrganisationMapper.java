package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.User.User_type;

public class OrganisationMapper {

	public ArrayList<Organisation> getOrganisations() throws SQLException {
		ArrayList<Organisation> result = new ArrayList<>();
		
		String SQLString = "SELECT * FROM organisations;";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			
			String organisation_name = rs.getString(1);
			
			result.add(new Organisation(organisation_name)); 
		}
		Connector.cleanUp(statement, rs);
		return result;
	}

	public void createOrganisation(Organisation organisation) throws SQLException {
		
		String SQLString = "INSERT INTO organisation (organisation_name) VALUES (?)";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setString(1, organisation.getName());

		
		statement.executeUpdate();
	}
	
	public void deleteBuilding(int id) throws SQLException {
		
		String SQLString = "DELETE FROM organisations WHERE user_id = ?";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setInt(1, id);
		
		statement.executeUpdate();
		
	}
	
}
