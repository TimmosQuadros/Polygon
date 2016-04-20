package data;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface ILogin {
	/**
	 * Returns the user if the password is correct or else it returns null.
	 * @param username
	 * @param password
	 * @return
	 */
	public User correctPassword(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	public String md5(String yourString) throws UnsupportedEncodingException, NoSuchAlgorithmException;

}
