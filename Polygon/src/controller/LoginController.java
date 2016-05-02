package controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Facade;
import data.User;

public class LoginController implements ILogin{

	Facade fac = new Facade();
	
	public User correctPassword(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		User user = null;
		try {
			user = fac.getUser(username, md5(password));
		} catch (SQLException e) {
			
			//If user is null -> Write: "wrong password or username"
			return null;
		}
		return user;
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
