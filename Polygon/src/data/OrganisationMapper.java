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
			int organisation_id = rs.getInt(1);
			String organisation_name = rs.getString(2);
			
			result.add(new Organisation(organisation_id, organisation_name)); 
		}
		Connector.cleanUp(statement, rs);
		return result;
	}

	public void createOrganisation(Organisation organisation) throws SQLException {
		
		String SQLString = "INSERT INTO organisation (organisation_id, organisation_name) VALUES (?,?)";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setInt(1, organisation.id);
		statement.setString(2, organisation.getName());

		
		statement.executeUpdate();
	}
	
	public void deleteBuilding(int id) throws SQLException {
		
		String SQLString = "DELETE FROM organisations WHERE user_id = ?";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setInt(1, id);
		
		statement.executeUpdate();
		
	}
	
}
