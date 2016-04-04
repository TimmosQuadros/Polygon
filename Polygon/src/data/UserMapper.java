package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.User.User_type;

public class UserMapper {

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

	public void createUser(User user,String organisation_name) throws SQLException {

		String SQLString;
		PreparedStatement statement;

		//*First add the organization to the database if it doesn't exists already.

		if(!new OrganisationMapper().organisationExists(organisation_name)){
			SQLString = "INSERT INTO organisations (organisation_name) VALUES (?)";
			statement = Connector.prepare(SQLString);

			statement.setString(1, organisation_name);
			statement.executeUpdate();
			statement.close();
		}

		//*

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

	public void deleteUser(int id) throws SQLException {

		String SQLString = "DELETE FROM Users WHERE user_id = ?";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, id);

		statement.executeUpdate();

	}




}
