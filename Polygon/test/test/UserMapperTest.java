package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import data.Organisation;
import data.OrganisationMapper;
import data.User;
import data.UserMapper;

public class UserMapperTest {

	UserMapper usermapper;
	OrganisationMapper organisationmapper;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		usermapper = new UserMapper();
		organisationmapper = new OrganisationMapper();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void userMapperTest() {
		ArrayList<User> users;
		ArrayList<Organisation> organisations;
		try {
			usermapper.createUser(new User(User.User_type.CUST, "Abe", "1234", "Email"),"DTU");

			users = usermapper.getUsers();
			organisations = organisationmapper.getOrganisations();

			assertTrue(!users.isEmpty());

			assertEquals(User.User_type.CUST,users.get(0).getUser_type());
			assertEquals("Abe",users.get(0).getUsername());
			assertEquals("1234",users.get(0).getPassword());
			assertEquals("Email",users.get(0).getUser_email());

			assertEquals("DTU", organisations.get(0).getName());

			usermapper.deleteUser(users.get(0).getUser_id());

			users = usermapper.getUsers();

			assertTrue(users.isEmpty());

		} catch (SQLException e) {

			fail(e.getMessage());
			e.printStackTrace();
		}

	}

}
