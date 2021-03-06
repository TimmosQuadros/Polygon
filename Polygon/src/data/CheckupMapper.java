package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import data.Checkup.OrderStatus;
import data.User.User_type;

public class CheckupMapper {
	public ArrayList<Checkup> getCheckups() throws SQLException {
		ArrayList<Checkup> result = new ArrayList<>();

		String SQLString = "SELECT * FROM checkup;";

		PreparedStatement statement = Connector.prepare(SQLString);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			int checkupID, buildingID, customerID, techID;
			String dateIssued, dateProcessed;
			OrderStatus status;
			checkupID = rs.getInt(1);
			buildingID = rs.getInt(2);
			customerID = rs.getInt(3);
			techID = rs.getInt(4);
			dateIssued = rs.getString(5);
			dateProcessed = rs.getString(6);
			status = OrderStatus.valueOf((String) rs.getObject(7));
			result.add(new Checkup(checkupID, buildingID, customerID, techID, dateIssued, dateProcessed, status));
		}
		Connector.cleanUp(statement, rs);
		return result;
	}

	public void createCheckup(Checkup c) throws SQLException {
		String SQLString = "INSERT INTO checkup (building_id, customer_id, date_issued, order_status) VALUES (?,?,?,?)";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, c.getBuildingID());
		statement.setInt(2, c.getCustomerID());
		statement.setString(3, c.getDateIssued());
		statement.setObject(4, c.getStatus().toString());

		statement.executeUpdate();
	}

	public void updateCheckup(Checkup c) throws SQLException {

		String SQLString = "UPDATE checkup SET building_id = ?, customer_id = ?, tech_id = ?, date_issued = ?, date_processed = ?, status = ? WHERE checkup = ?";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, c.getBuildingID());
		statement.setInt(2, c.getCustomerID());
		statement.setInt(3, c.getTechID());
		statement.setString(4, c.getDateIssued());
		statement.setString(5, c.getDateProcessed());
		statement.setObject(6, c.getStatus().toString());
		statement.setInt(7, c.getCheckupID());

		statement.executeUpdate();
	}

	public void addTech(Checkup c, int tech_id) throws SQLException {

		String SQLString = "UPDATE checkup SET tech_id = ?, order_status = ? WHERE checkup_id = ?";

		PreparedStatement statement = Connector.prepare(SQLString);

		c.setStatus(OrderStatus.PROGRESSING);
		statement.setInt(1, tech_id);
		
		statement.setObject(2, c.getStatus().toString());
		statement.setInt(3, c.getCheckupID());

		statement.executeUpdate();
	}
	


	public void deleteCheckup(int id) throws SQLException {

		String SQLString = "DELETE FROM checkup WHERE checkup_id = ?";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, id);

		statement.executeUpdate();

	}
}
