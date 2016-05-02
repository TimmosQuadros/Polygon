package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.User.User_type;

public class UserMapper {

	//returns an ArrayList of ALL users in the database
	public ArrayList<User> getUsers() throws SQLException {
		ArrayList<User> result = new ArrayList<>();

		String SQLString = "SELECT * FROM Users;";

		PreparedStatement statement = Connector.prepare(SQLString);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			int user_id = rs.getInt(1);
			int organisations_id = rs.getInt(2);
			User_type user_type = User_type.valueOf(rs.getString(3));
			String username = rs.getString(4);
			String password = rs.getString(5);
			String user_email = rs.getString(6);

			result.add(new User(user_id,organisations_id, user_type, username, password, user_email)); 
		}
		Connector.cleanUp(statement, rs);
		return result;
	}

	public User getUser(String username_2, String password_2) throws SQLException {

		String SQLString = "SELECT * FROM Users where username=? and password=?;";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setString(1, username_2);
		statement.setString(2, password_2);

		ResultSet rs = statement.executeQuery();

		User result=null;

		while (rs.next()) {
			int user_id = rs.getInt(1);
			int organisations_id = rs.getInt(2);
			User_type user_type = User_type.valueOf(rs.getString(3));
			String username = rs.getString(4);
			String password = rs.getString(5);
			String user_email = rs.getString(6);

			result = new User(user_id, organisations_id, user_type, username, password, user_email);
		}
		Connector.cleanUp(statement, rs);
		return result;
	}

	//adds a NEW user to the database. (consider adding the organisation to user object at a higher layer?)
	public void createUser(User user, String organisation_name) throws SQLException {

		String SQLString;
		PreparedStatement statement;

		//First add the organization to the database if it doesn't exists already and if the user doesn't exists.
		OrganisationMapper om = new OrganisationMapper();
		if(!om.organisationExists(user.getOrganisations_id()) && !userExists(user)){
			om.createOrganisation(new Organisation(organisation_name));
		}

		SQLString = "INSERT INTO users (organisations_id, user_type, username, password, user_email) VALUES (?,?,?,?,?)";
		statement = Connector.prepare(SQLString);

		statement.setInt(1, new OrganisationMapper().getID(organisation_name));
		statement.setString(2, user.getUser_type().name());
		statement.setString(3, user.getUsername());
		statement.setString(4, user.getPassword());
		statement.setString(5, user.getUser_email());

		statement.executeUpdate();
		statement.close();
	}

	/**
	 * Helper method to convert a String into an enum.
	 * @param usertype
	 * @return
	 */
	public User_type getUserType(String usertype){
		User.User_type user_type;
		if(usertype.equalsIgnoreCase("ADMIN")){
			user_type = User_type.valueOf("ADMIN");
		}
		if(usertype.equalsIgnoreCase("TECH")){
			user_type = User_type.valueOf("TECH");
		}
		if(usertype.equalsIgnoreCase("CUST")){
			user_type = User_type.valueOf("CUST");
		}else {
			throw new IllegalArgumentException();
		}
		return user_type;
	}
	//removes a user from the database (consider using a User object as parameter?)
	public void deleteUser(int id) throws SQLException {

		String SQLString = "DELETE FROM Users WHERE user_id = ?";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, id);

		statement.executeUpdate();

	}

	public boolean userExists(User u) throws SQLException{
		String SQLString = "SELECT * FROM Users where username=?;";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setString(1, u.getUsername());

		ResultSet rs = statement.executeQuery();

		if(rs.next()){
			return true;
		}
		return false;
	}

}
