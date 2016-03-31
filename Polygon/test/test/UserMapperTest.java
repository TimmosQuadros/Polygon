package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import data.User;
import data.UserMapper;

public class UserMapperTest {
	
	UserMapper usermapper;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		usermapper = new UserMapper();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void userMapperTest() {
		ArrayList<User> users;
		try {
			usermapper.createUser(new User("Abe", "Abe", "1234", User.User_type.CUST,"Email"));
			
			users = usermapper.getUsers();
			
			assertTrue(!users.isEmpty());
			
			assertEquals("Abe",users.get(0).getOrganisation_name());
			assertEquals("Abe",users.get(0).getUsername());
			assertEquals("1234",users.get(0).getPassword());
			assertEquals(User.User_type.CUST,users.get(0).getUser_type());
			assertEquals("Email",users.get(0).getUser_email());
			
			usermapper.deleteBuilding(users.get(0).getUser_id());
			
			users = usermapper.getUsers();
			
			assertTrue(users.isEmpty());
			
		} catch (SQLException e) {

			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
