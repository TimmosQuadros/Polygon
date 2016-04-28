package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import data.Building;
import data.BuildingMapper;
import data.Organisation;
import data.User;
import data.User.User_type;

public class BuildingMapperTest {

	private BuildingMapper bmapper;
	private int organisationID;
	private String organisationName;
	private String building_name;
	private String street_address;
	private int zip;
	private int build_year;
	private int floor_area;
	private User_type usertype;
	private String username;
	private String password;
	private String mail;
	
	private JdbcTestFixture fixture;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		organisationName = "test";
		
		building_name = "testBuilding";
		street_address = "testvej";
		zip = 1000;
		build_year = 1000;
		floor_area = 1;
		
		usertype = User_type.CUST;
		username = "testCustomer";
		password = "123456";
		mail = "test@test.dk";
		
		fixture = new JdbcTestFixture();
		bmapper = new BuildingMapper();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void createBuilding() {
		try {
			organisationID = fixture.setUp(new Organisation(organisationName));
			Building testBuilding = new Building(building_name, street_address, zip, build_year, floor_area);
			bmapper.createBuilding(testBuilding,organisationID);
			testBuilding = bmapper.getBuildings().get(0);

			assertEquals(building_name, testBuilding.getBuilding_name());
			assertEquals(street_address, testBuilding.getStreet_address());
			assertEquals(zip, testBuilding.getZip());
			assertEquals(build_year, testBuilding.getBuild_year());
			assertEquals(floor_area, testBuilding.getFloor_area());
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void updateBuilding() {
		try {
			int[] ids = fixture.setUp(new Building(building_name, street_address, zip, build_year, floor_area), 
					new Organisation(organisationName));
			building_name = "testBuildingUpdated";
			street_address = "testvejUpdated";
			zip = 1001;
			build_year = 1001;
			floor_area = 2;
			Building updateBuilding = new Building(building_name, street_address, zip, build_year, floor_area);
			updateBuilding.setOrganisation_id(ids[0]);
			updateBuilding.setBuilding_id(ids[1]);
			bmapper.updateBuilding(updateBuilding);
			Building testBuilding = bmapper.getBuildings().get(0);
			
			assertEquals(building_name, testBuilding.getBuilding_name());
			assertEquals(street_address, testBuilding.getStreet_address());
			assertEquals(zip, testBuilding.getZip());
			assertEquals(build_year, testBuilding.getBuild_year());
			assertEquals(floor_area, testBuilding.getFloor_area());
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void getUserBuilding() {
		try {
			int[] ids = fixture.setUp(new User(usertype, username, password, mail), 
					new Building(building_name, street_address, zip, build_year, floor_area), 
					new Organisation(organisationName));
			
			Building userBuilding = bmapper.getUserBuildings(ids[2]).get(0);
			
			assertEquals(building_name, userBuilding.getBuilding_name());
			assertEquals(street_address, userBuilding.getStreet_address());
			assertEquals(zip, userBuilding.getZip());
			assertEquals(build_year, userBuilding.getBuild_year());
			assertEquals(floor_area, userBuilding.getFloor_area());
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void deleteBuilding() {
		try {
			//Create an organization and a building
			int[] ids = fixture.setUp(new Building(building_name, street_address, zip, build_year, floor_area), 
					new Organisation(organisationName));
			bmapper.deleteBuilding(ids[1]);
			assertTrue(bmapper.getBuildings().size()==0);
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	
}
