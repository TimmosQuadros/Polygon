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

}
