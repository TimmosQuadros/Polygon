package data;

public interface ILogin {
	/**
	 * Returns the user if the password is correct or else it returns null.
	 * @param username
	 * @param password
	 * @return
	 */
	public User correctPassword(String username, String password);

}
