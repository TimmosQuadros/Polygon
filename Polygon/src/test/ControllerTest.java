package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import presentation.Controller;
import data.Building;
import data.Facade;

public class ControllerTest {
	
	Controller controller;
	Facade facade;
	
	@Before
	public void setUp() throws Exception {
		controller = new Controller();
		facade = new Facade();
	}
	
	@Test
	public void updateBuildingTest() throws SQLException {
		ArrayList<Building> buildings;
		
		try {
			buildings = facade.getAllBuildings();
			Building b = buildings.get(0);
			b.setBuilding_name("tester name");
			controller.commitBuildingUpdate(b);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals("tester name", facade.getAllBuildings().get(0).getBuilding_name());
	}
}
