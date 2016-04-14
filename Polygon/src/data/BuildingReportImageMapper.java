package data;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.BuildingReportImage.Type;

public class BuildingReportImageMapper {

	public ArrayList<BuildingReportImage> getBuildingReportImages(int report_id,Type type) throws SQLException{

		String SQLString = "select * from building_report_image where report_id=? and image_type=?;";
		PreparedStatement statement = Connector.prepare(SQLString);
		statement.setInt(1, report_id);
		statement.setObject(2, type);
		ResultSet rs = statement.executeQuery();
		ArrayList<BuildingReportImage> report_images = new ArrayList<>();

		while (rs.next()) {

			int image_id = rs.getInt(1);

			File image = new Facade().getImage(image_id);

			report_images.add(new BuildingReportImage(image_id, report_id, type, image));
		}

		return report_images;
	}

	public ArrayList<BuildingReportImage> getBuildingReportImages(int report_id) throws SQLException{

		String SQLString = "select * from building_report_image where report_id=?;";
		PreparedStatement statement = Connector.prepare(SQLString);
		statement.setInt(1, report_id);
		ResultSet rs = statement.executeQuery();
		ArrayList<BuildingReportImage> report_images = new ArrayList<>();

		while (rs.next()) {

			int image_id = rs.getInt(1);
			Type type = Type.valueOf((String)rs.getObject(3));

			File image = new Facade().getImage(image_id);

			report_images.add(new BuildingReportImage(image_id, report_id, type, image));
		}

		return report_images;
	}

}
