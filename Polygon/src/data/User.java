package data;

public class User {
	
	String username, password, user_email;
	int user_id,organisations_id;
	public enum User_type {ADMIN, TECH, CUST}
	User_type user_type;
	
	public User(int user_id ,int organisations_id, User_type user_type, String username, String password, String user_email) {
		super();
		this.user_id = user_id;
		this.organisations_id=organisations_id;
		this.user_type = user_type;
		this.username = username;
		this.password = password;
		this.user_email = user_email;
	}
	
	public User(User_type user_type, String username, String password, String user_email) {
		super();
		this.user_type = user_type;
		this.username = username;
		this.password = password;
		this.user_email = user_email;
	}
	
	public int getOrganisations_id() {
		return organisations_id;
	}

	public void setOrganisations_id(int organisations_id) {
		this.organisations_id = organisations_id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
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
