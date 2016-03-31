package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.User.User_type;

public class UserMapper {
	
	User.User_type user_type;
	
	public ArrayList<User> getUsers() throws SQLException {
		ArrayList<User> result = new ArrayList<>();
		
		String SQLString = "SELECT * FROM Users;";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			
			int user_id = rs.getInt(1);
			String organisation_name = rs.getString(2);
			if(rs.getString(3).equalsIgnoreCase("ADMIN")){
				user_type = User_type.valueOf("ADMIN");
			}
			if(rs.getString(3).equalsIgnoreCase("TECH")){
				user_type = User_type.valueOf("TECH");
			}
			if(rs.getString(3).equalsIgnoreCase("CUST")){
				user_type = User_type.valueOf("CUST");
			}else {
				//execption her? fejlmeddelelse eller termination?
			}
			String username = rs.getString(4);
			String password = rs.getString(5);
			String user_email = rs.getString(6);
			
			result.add(new User(organisation_name, username, password, user_id, user_type, user_email)); 
		}
		Connector.cleanUp(statement, rs);
		return result;
	}

	public void createUser(User user) throws SQLException {
		
		String SQLString = "INSERT INTO users (organisation_name, username, password, user_type, user_email) VALUES (?,?,?,?,?)";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setString(1, user.getOrganisation_name());
		statement.setString(2, user.getUsername());
		statement.setString(3, user.getPassword());
		statement.setString(4, user.getUser_type().name()); 
		statement.setString(5, user.getUser_email());
		
		statement.executeUpdate();
	}
	
	public void deleteBuilding(int id) throws SQLException {
		
		String SQLString = "DELETE FROM users WHERE user_id = ?";
		
		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setInt(1, id);
		
		statement.executeUpdate();
		
	}
}
