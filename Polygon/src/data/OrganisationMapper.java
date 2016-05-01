package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.User.User_type;

public class OrganisationMapper {
	
	//returns a list of ALL organisations in the database
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
	//adds a NEW organisation to the database
	public void createOrganisation(Organisation organisation) throws SQLException {
		
		String SQLString = "INSERT INTO organisations (organisation_name) VALUES (?)";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setString(1, organisation.getName());

		statement.executeUpdate();
	}
	
	/**
	 * Helper method so you can get the organisation id from the unique name.
	 * @param organisation_name
	 * @return
	 * @throws SQLException
	 */
	public int getID(String organisation_name) throws SQLException{
		
		ArrayList<Organisation> organisations;
		
		organisations = getOrganisations();
		
		for (Organisation organisation : organisations) {
			if(organisation.getName().equalsIgnoreCase(organisation_name)){
				return organisation.getId();
			}
		}
		
		return 0;
	}
	
	/**
	 * Helper method so you doesn't add multiple organisations with the same name.
	 * @param organisation_name
	 * @return
	 * @throws SQLException
	 */
	public boolean organisationExists(int organisation_id) throws SQLException{

		String SQLString = "SELECT * FROM organisations WHERE organisations_id=?";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, organisation_id);
		
		ResultSet rs = statement.executeQuery();

		if(!rs.next()){
			return false;
		}

		return true;
	}
	
	public void deleteOrganisation(String organisation_name) throws SQLException {

		String SQLString = "DELETE FROM organisations WHERE organisation_name = ?";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setString(1, organisation_name);

		statement.executeUpdate();

	}
}
