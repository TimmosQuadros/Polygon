package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Building;
import data.Organisation;
import data.User;
import data.User.User_type;

public class JdbcTestFixture {
	private Connection connection;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/polygon";
	private static String id = "root";
	private static String pw = "hFHA3YsT,@:p";
	
	public int[] setUp(User u,Building b, Organisation o) throws SQLException {
		int orgID=0;
		int buildID=0;
		int userID=0;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(URL, id, pw);
			// start transaction
			connection.setAutoCommit(false);

			//SQL
			String deleteUsers = "Delete from users where user_id>0";
			String deleteBuildings = "Delete from buildings where building_id>0;";
			String deleteOrganisations = "Delete from organisations where organisations_id>0";
			String insertOrganisation = "INSERT INTO `organisations` (`organisation_name`) VALUES (?);";
			String insertBuildings = "INSERT INTO `buildings` (`organisations_id`, `building_name`, `street_address`, `zipcode`, `build_year`, `floor_area`) VALUES (?,?,?,?,?,?);";
			String insertUsers = "INSERT INTO `users` (`organisations_id`, `user_type`, `username`, `password`, `user_email`) VALUES (?,?,?,?,?);";

			//Delete
			PreparedStatement ps = connection.prepareStatement(deleteUsers);
			ps.addBatch();
			ps.executeBatch();
			ps = connection.prepareStatement(deleteBuildings);
			ps.addBatch();
			ps.executeBatch();
			ps = connection.prepareStatement(deleteOrganisations);
			ps.addBatch();
			ps.executeBatch();
			
			//Insert organization
			ps = connection.prepareStatement(insertOrganisation,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, o.getName());
			ps.addBatch();
			ps.executeBatch();
			
			//Get the auto incremented key
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				orgID = rs.getInt(1);
			}

			//Insert building
			ps = connection.prepareStatement(insertBuildings,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, orgID);
			ps.setString(2, b.getBuilding_name());
			ps.setString(3, b.getStreet_address());
			ps.setInt(4, b.getZip());
			ps.setInt(5, b.getBuild_year());
			ps.setInt(6, b.getFloor_area());
			ps.addBatch();
			ps.executeBatch();
			
			//Get the auto incremented key
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				buildID = rs.getInt(1);
			}
			
			//Insert user
			ps = connection.prepareStatement(insertUsers,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, orgID);
			ps.setString(2, u.getUser_type().name());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getUser_email());
			ps.addBatch();
			ps.executeBatch();
			
			//Get the auto incremented key
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				userID = rs.getInt(1);
			}
			
			// end transaction
			connection.commit();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Fail in JdbcTestFixture - setup");
			System.out.println(e.getMessage());
		} finally {
			connection.close();
		}
		int[] array= {orgID,buildID,userID};
		return array;
	}

	public int[] setUp(Building b, Organisation o) throws SQLException {
		int orgID=0;
		int buildID=0;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(URL, id, pw);
			// start transaction
			connection.setAutoCommit(false);

			//SQL
			String deleteUsers = "Delete from users where user_id>0";
			String deleteBuildings = "Delete from buildings where building_id>0;";
			String deleteOrganisations = "Delete from organisations where organisations_id>0";
			String insertOrganisation = "INSERT INTO `organisations` (`organisation_name`) VALUES (?);";
			String insertBuildings = "INSERT INTO `buildings` (`organisations_id`, `building_name`, `street_address`, `zipcode`, `build_year`, `floor_area`) VALUES (?,?,?,?,?,?);";

			//Delete
			PreparedStatement ps = connection.prepareStatement(deleteUsers);
			ps.addBatch();
			ps.executeBatch();
			ps = connection.prepareStatement(deleteBuildings);
			ps.addBatch();
			ps.executeBatch();
			ps = connection.prepareStatement(deleteOrganisations);
			ps.addBatch();
			ps.executeBatch();
			
			//Insert organization
			ps = connection.prepareStatement(insertOrganisation,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, o.getName());
			ps.addBatch();
			ps.executeBatch();
			
			//Get the auto incremented key
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				orgID = rs.getInt(1);
			}

			//Insert building
			ps = connection.prepareStatement(insertBuildings,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, orgID);
			ps.setString(2, b.getBuilding_name());
			ps.setString(3, b.getStreet_address());
			ps.setInt(4, b.getZip());
			ps.setInt(5, b.getBuild_year());
			ps.setInt(6, b.getFloor_area());
			ps.addBatch();
			ps.executeBatch();
			
			//Get the auto incremented key
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				buildID = rs.getInt(1);
			}
			
			// end transaction
			connection.commit();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Fail in JdbcTestFixture - setup");
			System.out.println(e.getMessage());
		} finally {
			connection.close();
		}
		int[] array= {orgID,buildID};
		return array;
	}
	
	public int setUp(Organisation o) throws SQLException {
		int orgID=0;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(URL, id, pw);
			// start transaction
			connection.setAutoCommit(false);

			//SQL
			String deleteUsers = "Delete from users where user_id>0";
			String deleteBuildings = "Delete from buildings where building_id>0;";
			String deleteOrganisations = "Delete from organisations where organisations_id>0";
			String insertOrganisation = "INSERT INTO `organisations` (`organisation_name`) VALUES (?);";

			//Delete
			PreparedStatement ps = connection.prepareStatement(deleteUsers);
			ps.addBatch();
			ps.executeBatch();
			ps = connection.prepareStatement(deleteBuildings);
			ps.addBatch();
			ps.executeBatch();
			ps = connection.prepareStatement(deleteOrganisations);
			ps.addBatch();
			ps.executeBatch();
			
			//Insert organization
			ps = connection.prepareStatement(insertOrganisation,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, o.getName());
			ps.addBatch();
			ps.executeBatch();
			
			//Get the auto incremented key
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				orgID = rs.getInt(1);
			}
			
			// end transaction
			connection.commit();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Fail in JdbcTestFixture - setup");
			System.out.println(e.getMessage());
		} finally {
			connection.close();
		}
		return orgID;
	}


	public void tearDown() {
		
		try {
			
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
