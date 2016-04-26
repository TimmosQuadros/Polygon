package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Controller;
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
	private ArrayList<Organisation> organisations;
	private String orgName;
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
		organisations = omapper.getOrganisations();
		if(organisations.isEmpty()){
			orgName = "testOrg";
			omapper.createOrganisation(new Organisation(orgName));
		}else{
			orgName = organisations.get(0).getName();
		}
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void createBuilding() {
		try {
			int numberOfBuildings = buildings.size();
			
			bmapper.createBuilding(new Building("TestBuilding", "test", 2800, 1978, 999999), organisations.get(0).getId());
			Building b = bmapper.getBuildings().get(numberOfBuildings);
			buildings = bmapper.getBuildings();
			assertTrue((numberOfBuildings+1)==bmapper.getBuildings().size());
			assertEquals("TestBuilding",b.getBuilding_name());
			assertEquals("test",b.getStreet_address());
			assertEquals(2800,b.getZip());
			assertEquals(1978,b.getBuild_year());
			assertEquals(999999,b.getFloor_area());
		} catch (SQLException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateBuilding() {
		try {
			buildings = bmapper.getBuildings();
			int numberOfBuildings = buildings.size();
			Building updatedBuilding = buildings.get(numberOfBuildings-1);
			updatedBuilding.setBuilding_name("testUpdateBuildingName");
			updatedBuilding.setStreet_address("testUpdateStreet");
			updatedBuilding.setZip(2900);
			updatedBuilding.setBuild_year(1979);
			updatedBuilding.setFloor_area(9);
			bmapper.updateBuilding(updatedBuilding);
			
			Building b = bmapper.getBuildings().get(numberOfBuildings-1);
			
			assertEquals("testUpdateBuildingName",b.getBuilding_name());
			assertEquals("testUpdateStreet",b.getStreet_address());
			assertEquals(2900,b.getZip());
			assertEquals(1979,b.getBuild_year());
			assertEquals(9,b.getFloor_area());
			
		} catch (SQLException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void getUserBuilding() {
		try {
			User user = new User(User_type.CUST, "test", "123456", "test@org.com");
			umapper.createUser(user, orgName);
			ArrayList<User> users = umapper.getUsers();
			user = users.get(users.size()-1);
			ArrayList<Building> buildingss = bmapper.getUserBuildings(user.getUser_id());
			assertTrue(buildingss.size()==1);
			
			Building b = buildingss.get(buildings.size()-1);
			
			assertEquals("testUpdateBuildingName",b.getBuilding_name());
			assertEquals("testUpdateStreet",b.getStreet_address());
			assertEquals(2900,b.getZip());
			assertEquals(1979,b.getBuild_year());
			assertEquals(9,b.getFloor_area());
			
			umapper.deleteUser(user.getUser_id());
			
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void deleteBuilding() {
		try {
			int numberOfBuildings = buildings.size(); 
			bmapper.deleteBuilding(bmapper.getMaxBuildingId());
			assertTrue(numberOfBuildings-1==bmapper.getBuildings().size());
		} catch (SQLException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
