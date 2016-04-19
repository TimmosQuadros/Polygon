package controller;

import java.sql.SQLException;

import data.Building;
import data.Connector;
import data.Facade;

public class Controller {

	Facade fac = new Facade();
	
	public boolean commitBuildingUpdate(Building b) throws SQLException {
		
		try {
			Connector.setAutoCommit(false);
			
			fac.updateBuilding(b);
		
			Connector.commit();
			
		} catch (SQLException e) {
			Connector.rollback();
			Connector.setAutoCommit(true);
			return false;
		}
		Connector.setAutoCommit(true);
		return true;
	}
}