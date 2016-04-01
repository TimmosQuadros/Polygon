package data;

public class User {
	
	String organisation_name, username, password, user_email;
	int user_id;
	public enum User_type {ADMIN, TECH, CUST}
	User_type user_type;
	
	public User(String organisation_name, String username, String password, int user_id, User_type user_type, String user_email) {
		super();
		this.organisation_name = organisation_name;
		this.username = username;
		this.password = password;
		this.user_id = user_id;
		this.user_type = user_type;
		this.user_email = user_email;
	}
	
	public User(String organisation_name, String username, String password, User_type user_type, String user_email) {
		super();
		this.organisation_name = organisation_name;
		this.username = username;
		this.password = password;
		this.user_type = user_type;
		this.user_email = user_email;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getOrganisation_name() {
		return organisation_name;
	}

	public void setOrganisation_name(String organisation_name) {
		this.organisation_name = organisation_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public User_type getUser_type() {
		return user_type;
	}

	public void setUser_type(User_type user_type) {
		this.user_type = user_type;
	}
	
	



}
