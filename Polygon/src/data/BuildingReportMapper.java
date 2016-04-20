package data;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.BuildingReport.BuildingCondition;
import data.BuildingReportImage.Type;

public class BuildingReportMapper {
	
	
public ArrayList<BuildingReport> getBuildingReports() throws SQLException{
		
		String SQLString = "select * from building_report;";
		PreparedStatement statement = Connector.prepare(SQLString);
		ResultSet rs = statement.executeQuery();
		ArrayList<BuildingReport> reports = new ArrayList<>();
		
		while (rs.next()) {

			int report_id = rs.getInt(1);
			int building_id = rs.getInt(2);
			int tech_id = rs.getInt(3);
			String roof_remarks = rs.getString(4);
			String outer_wall_remark = rs.getString(5);
			String facility_manager_name = rs.getString(6);
			BuildingCondition condition = BuildingCondition.valueOf((String)rs.getObject(7));
			reports.add(new BuildingReport(report_id, building_id, tech_id, roof_remarks, outer_wall_remark, facility_manager_name, condition));

		}
		
		return reports;
	}
	
	
	public void createReport(BuildingReport report) throws SQLException{
		String SQLString = "INSERT INTO building_report (report_id, building_id, tech_id, roof_remark, outer_wall_remark, facility_manager_name, building_condition) VALUES (?,?,?,?,?,?,?)";

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
