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
import data.Organisation;
import data.OrganisationMapper;
import data.User;
import data.User.User_type;
import data.UserMapper;

public class BuildingMapperTest {

	private BuildingMapper bmapper;
	private OrganisationMapper omapper;
	private UserMapper umapper;
	private ArrayList<Building> buildings;
	private ArrayList<User> users;
	private String organisationName;
	private Building testBuilding;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		bmapper = new BuildingMapper();
		omapper = new OrganisationMapper();
		umapper = new UserMapper();
		buildings = bmapper.getBuildings();
	}

	@After
	public void tearDown() throws Exception {
		bmapper=null;
		omapper=null;
		umapper=null;
		buildings=null;
	}

	
	public void createBuilding() {
		try {
			int numberOfBuildings = buildings.size();
			organisationName = "test";
			String building_name = "testBuilding";
			String street_address = "testvej";
			int zip = 1000;
			int build_year = 1000;
			int floor_area = 1;
			testBuilding = new Building(building_name, street_address, zip, build_year, floor_area);
			omapper.createOrganisation(new Organisation(organisationName));
			bmapper.createBuilding(testBuilding,omapper.getID(organisationName));
			buildings = bmapper.getBuildings();
			testBuilding=buildings.get(buildings.size()-1);
			
			assertTrue(buildings.size()==numberOfBuildings+1);
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
		createBuilding();
		System.out.println(buildings.size()+" update");
		try {
			
			for (Building building : buildings) {
				if(building.getBuilding_name().equalsIgnoreCase("testBuilding")) testBuilding = building;
			}
			if(testBuilding==null)fail();
			String building_name = "testBuildingUpdated";
			String street_address = "testvejUpdated";
			int zip = 1001;
			int build_year = 1001;
			int floor_area = 2;
			testBuilding.setBuilding_name(building_name);
			testBuilding.setStreet_address(street_address);
			testBuilding.setZip(zip);
			testBuilding.setBuild_year(build_year);
			testBuilding.setFloor_area(floor_area);
			bmapper.updateBuilding(testBuilding);
			buildings = bmapper.getBuildings();
			testBuilding=buildings.get(buildings.size()-1);
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
	
	//@Test
	public void getUserBuilding() {
		try {
			buildings = bmapper.getBuildings();
			String username = "test";
			String password = "123456";
			String email = "user@user.dk";
			User user = null;
			umapper.createUser(new User(User_type.CUST, username, password, email), organisationName);
			umapper.getUsers();
			for (User us : users) {
				if(us.getUsername().equalsIgnoreCase(username)){
					user = us;
				}
			}
			if(user==null)fail("user is null");
			ArrayList<Building> userBuildings = bmapper.getUserBuildings(user.getUser_id());
			Building userBuilding = userBuildings.get(0);
			assertTrue(userBuilding!=null);
			assertEquals(testBuilding.getBuilding_name(), userBuilding.getBuilding_name());
			assertEquals(testBuilding.getStreet_address(), userBuilding.getStreet_address());
			assertEquals(testBuilding.getZip(), userBuilding.getZip());
			assertEquals(testBuilding.getBuild_year(), userBuilding.getBuild_year());
			assertEquals(testBuilding.getFloor_area(), userBuilding.getFloor_area());
			//Clean up
			umapper.deleteUser(user.getUser_id());
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void deleteBuilding() {
		try {
			System.out.println(buildings.size()+" delete");
			int numberOfBuildings = buildings.size();
			for (Building building : buildings) {
				if(building.getBuilding_name().equalsIgnoreCase("testBuildingUpdated")) testBuilding = building;
			}
			if(testBuilding==null)fail();
			bmapper.deleteBuilding(testBuilding.getBuilding_id());
			buildings = bmapper.getBuildings();
			assertTrue(numberOfBuildings-1==buildings.size());
			//Clean up
			omapper.deleteOrganisation("test");
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	public Building getBuilding(String name){
		for (Building building : buildings) {
			System.out.println("abe");
			if(building.getBuilding_name().equalsIgnoreCase(name)) return building;
		}
		return null;
	}
}
