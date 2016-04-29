package data;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController implements ILogin{

	Facade fac = new Facade();
	
	public User correctPassword(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		try {
			ArrayList<User> users = fac.getUsers();
			for (User user : users) {
				if(user.getUsername().equals(username)){
					if(user.getPassword().equalsIgnoreCase(md5(password))){
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
	
	public String md5(String yourString) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		byte[] bytesOfMessage = yourString.getBytes("UTF-8");

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		BigInteger bigInt = new BigInteger(1,thedigest);
		String hashText = bigInt.toString(16);
		//Zero padding to 32 char
		while(hashText.length() < 32 ){
			hashText = "0"+hashText;
		}
		return hashText;
	}

}
