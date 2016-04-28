package data;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController implements ILogin{

	UserMapper userMapper = new UserMapper();
	
	public User correctPassword(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		try {
			ArrayList<User> users = userMapper.getUsers();
			for (User user : users) {
				if(user.getUsername().equals(username)){
					if(user.getPassword().equalsIgnoreCase(md5(password))){
						return user;
					}
				}
			}
		} catch (SQLException e) {
			//If user is null -> Write: "wrong password or username"
			return null;
		}
		return null;
	}
	
	public String md5(String textToBeConverted) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		byte[] bytesMessage = textToBeConverted.getBytes("UTF-8");
		MessageDigest mesd = MessageDigest.getInstance("MD5");
		byte[] digest = mesd.digest(bytesMessage);
		BigInteger bigInteger = new BigInteger(1,digest);
		String hashString = bigInteger.toString(16);
		while(hashString.length() < 32 ){
			hashString = "0"+hashString;
		}
		return hashString;
	}

}
