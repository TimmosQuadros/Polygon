package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import data.Building;
import data.BuildingMapper;
import data.User;
import data.UserMapper;

public class BuildingMapperTest {

	BuildingMapper bmapper;
	UserMapper usermapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		bmapper = new BuildingMapper();
		usermapper = new UserMapper();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void mapperTest() {
		boolean didThrowSQLException=false;
		ArrayList<Building> buildings = null;
		try {
			ArrayList<User> users;

			users = usermapper.getUsers();

			User user= users.get(0);

			//Test create building #Start#
			String building_name="DTU",street_address="Ankerenglundsvej nr. 1";
			int zip=2800,build_year=1978,floor_area=2050,organisation_id=user.getOrganisations_id();

			bmapper.createBuilding(new Building(building_name, street_address, zip, build_year, floor_area),organisation_id);

			buildings = bmapper.getBuildings();

			assertTrue(!buildings.isEmpty());
			Building b = buildings.get(0);
			assertEquals(building_name, b.getBuilding_name());
			assertEquals(street_address, b.getStreet_address());
			assertEquals(zip, b.getZip());
			assertEquals(floor_area, b.getFloor_area());
			assertEquals(organisation_id, b.getOrganisation_id());
			//Test create building #End#

			//Test getUserBuilding #Start#
			ArrayList<Building> userBuildings;

			userBuildings = bmapper.getUserBuildings(user.getUser_id());

			Building userB = userBuildings.get(0);

			assertTrue(!userBuildings.isEmpty());
			assertEquals(building_name, userB.getBuilding_name());
			assertEquals(street_address, userB.getStreet_address());
			assertEquals(zip, userB.getZip());
			assertEquals(floor_area, userB.getFloor_area());
			assertEquals(organisation_id, userB.getOrganisation_id());
			//Test getUserBuilding #End#

		//Test SQLException #Start#
			b.setBuilding_name("DTU");
			bmapper.createBuilding(b, organisation_id+1);
		} catch (SQLException e) {
			didThrowSQLException=true;
		}
		assertTrue(didThrowSQLException);
		//Test SQLException #End#

		//Test delete building #Start#
		int id = buildings.get(0).getBuilding_id();

		try {
			bmapper.deleteBuilding(id);
			buildings = bmapper.getBuildings();
			assertTrue(buildings.size()==0);
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		//Test delete building #End#
	}

}
