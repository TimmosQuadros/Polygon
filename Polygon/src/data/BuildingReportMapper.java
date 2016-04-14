package data;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.BuildingReport.BuildingCondition;
import data.BuildingReportImage.Type;

public class BuildingReportMapper {
	
	public ArrayList<BuildingReport> getBuildingReports(int building_id) throws SQLException{
		
		String SQLString = "select * from building_report where building_id=?;";
		PreparedStatement statement = Connector.prepare(SQLString);
		statement.setInt(1, building_id);
		ResultSet rs = statement.executeQuery();
		ArrayList<BuildingReport> reports = new ArrayList<>();
		
		while (rs.next()) {

			int report_id = rs.getInt(1);
			int tech_id = rs.getInt(2);
			String roof_remark = rs.getString(4);
			
			
			BuildingCondition condition = BuildingCondition.valueOf((String)rs.getObject(7));

			//File image = new Facade().getImage(image_id);

			//report_images.add(new BuildingReportImage(image_id, report_id, type,image));
		}
		
		return null;
	}
	
	public void createReport(BuildingReport report) throws SQLException{
		String SQLString = "INSERT INTO building_report (report_id, building_id, tech_id, roof_remark, outer_wall_remark, facility_manager_name, ) VALUES (?,?,?,?,?,?,?)";

		PreparedStatement statement = Connector.prepare(SQLString);
		
		statement.setInt(1, report.getReport_id());
		statement.setInt(2, report.getBuilding_id());
		statement.setInt(3, report.getTech_id());
		statement.setString(4, report.getRoof_remark());
		statement.setString(5, report.getOuter_wall_remark());
		statement.setString(6, report.getFacility_manager_name());
		statement.setString(7,report.getBuildingCondition().name());

		statement.executeUpdate();
	}

}
