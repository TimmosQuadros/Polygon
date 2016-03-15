package Model;

import java.sql.*;

public class Connection {
	private final String USERNAME = "root";
	private final String PASSWORD = "hFHA3YsT,@:p";
	private String url = "";

	private java.sql.Connection con;

	public java.sql.Connection getConnection(String dbName) throws SQLException{
		this.url="jdbc:mysql://127.0.0.1:3306/"+dbName;
		con = DriverManager.getConnection(url, USERNAME, PASSWORD);
		return this.con;
	}

}
