package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemarkMapper {

	public void createRemark(Remark r) throws SQLException{
		String SQLString = "INSERT INTO remark (remark_id,room_report_id,description,type) VALUES (?,?,?,?)";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, r.getRemarkiId());
		statement.setInt(2,r.getRoomReportId());
		statement.setString(3, r.getDescription());
		statement.setString(4, r.getType());

		statement.executeUpdate();
	}
	
}
