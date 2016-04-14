package test;

import java.sql.SQLException;

import data.Building;
import data.Facade;
import data.User;

public class DatabasePopulator {

	public static void main(String[] args) throws SQLException {
		Facade fac = new Facade();
		
		fac.createUser(new User(User.User_type.ADMIN, "testadmin", "123456", "admin@mail.com"), "testorg1");
		fac.createUser(new User(User.User_type.CUST, "testcust", "123456", "cust@mail.com"), "testorg2");
		fac.createUser(new User(User.User_type.TECH, "testtech", "123456", "tech@mail.com"), "testorg1");
		for (int i = 1; i <= 3; i++) {
			fac.createBuilding(new Building("testbuilding".concat(String.valueOf(i)), "testaddress".concat(String.valueOf(i)), (340 + i) * 10, 1990 + i, i * 40), 2);
		}
	}

}
