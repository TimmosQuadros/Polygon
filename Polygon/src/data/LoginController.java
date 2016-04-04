package data;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController implements ILogin{

	UserMapper userMapper = new UserMapper();
	
	public User correctPassword(String username, String password){
		try {
			ArrayList<User> users = userMapper.getUsers();
			for (User user : users) {
				if(user.getUsername().equals(username)){
					if(user.getPassword().equals(password)){
						return user;
					}
				}
			}
		} catch (SQLException e) {
			//TODO Handle the exception
			return null;
		}

		return null;
	}

}
