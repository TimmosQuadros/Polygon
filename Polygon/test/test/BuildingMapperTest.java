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

public class BuildingMapperTest {

	BuildingMapper bmapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		bmapper = new BuildingMapper();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void mapperTest() {
		try {
			bmapper.createBuilding(new Building("Polygon", "Allerød", 3200, 1982, 32));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Building> buildings = null;
		try {
			buildings = bmapper.getBuildings();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(buildings!=null){
			assertTrue(buildings.size()>0);
		}else{
			fail("Fail!");	
		}
		int id = buildings.get(0).getBuilding_id();
		try {
			bmapper.deleteBuilding(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			buildings.clear();
			buildings = bmapper.getBuildings();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(buildings.isEmpty()){
			assertTrue(buildings.size()==0);
		}else{
			fail("Fail!");	
		}
	}

}
