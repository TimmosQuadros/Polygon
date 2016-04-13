package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import com.mysql.fabric.xmlrpc.base.Array;

public class ImageMapper {

	public void createImage(File file,String image_name) throws SQLException {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String SQLString = "INSERT INTO Image (image_type, image, image_size, image_name) VALUES (?,?,?,?)";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setString(1,".png");
		statement.setBinaryStream(2, fis, (int) file.length());
		statement.setString(3,String.valueOf(file.length()));
		statement.setString(4, image_name);

		statement.executeUpdate();
	}



	public void createFloorplan(int image_id, int building_id) throws SQLException {

		String SQLString = "INSERT INTO floorplans (image_id, building_id) VALUES (?,?)";

		PreparedStatement statement = Connector.prepare(SQLString);


		statement.setInt(1, image_id);
		statement.setInt(2,building_id);



		statement.executeUpdate();
	}

	/**
	 * Returns a list of image paths which is stored temporary and overwritten every time this method is called.
	 * @param user_id
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public ArrayList<String> getBuildingFloorplans(int building_id, ServletContext sc) throws SQLException, IOException{

		String SQLString = "Select image from floorplans natural join image where building_id=?";

		PreparedStatement statement = Connector.prepare(SQLString);

		statement.setInt(1, building_id);

		ResultSet resultSet = statement.executeQuery();

		ArrayList<String> images = new ArrayList<>();

		String FilePath = sc.getRealPath("/");

		String ServerPath = FilePath+"Resources\\Images\\Floorplans";

		FileUtils.cleanDirectory(new File(ServerPath));

		int i = 0;

		while (resultSet.next()) {
			String image_path=FilePath+"Resources\\Images\\Floorplans\\Floorplan"+i+".png";
			File image = new File(image_path);
			FileOutputStream fos = new FileOutputStream(image);
			byte[] buffer = new byte[1];
			InputStream is = resultSet.getBinaryStream(1);
			while (is.read(buffer) > 0) {
				fos.write(buffer);
			}
			fos.close();
			images.add(image_path);
			i++;
		}
		return images;
	}

	public int getMaxImageId() throws SQLException{
		String SQLString = "select max(image_id) from image;";

		PreparedStatement statement = Connector.prepare(SQLString);

		ResultSet resultSet = statement.executeQuery();

		int result;
		
		resultSet.next();
		
		result=resultSet.getInt(1);

		return result;
	}

	public ArrayList<File> getRoofImages(int report_id) throws SQLException, IOException{
		String SQLString = "select image from image natural join building_report_image natural join building_report where report_id=? and image_type='ROOF' group by image_id";
		PreparedStatement statement = Connector.prepare(SQLString);
		statement.setInt(1, report_id);
		ResultSet resultSet = statement.executeQuery();

		ArrayList<File> files = new ArrayList<>();

		while (resultSet.next()) {
			File file = File.createTempFile("img", ".png");
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1];
			InputStream is = resultSet.getBinaryStream(1);
			while (is.read(buffer) > 0) {
				fos.write(buffer);
			}
			fos.close();
			files.add(file);
		}
		return files;
	}

	public ArrayList<File> getOuterWallImages(int report_id) throws SQLException, IOException{
		String SQLString = "select image from image natural join building_report_image natural join building_report where report_id=? and image_type='OUTER_WALL' group by image_id";
		PreparedStatement statement = Connector.prepare(SQLString);
		statement.setInt(1, report_id);
		ResultSet resultSet = statement.executeQuery();

		ArrayList<File> files = new ArrayList<>();

		while (resultSet.next()) {
			File file = File.createTempFile("img", ".png");
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1];
			InputStream is = resultSet.getBinaryStream(1);
			while (is.read(buffer) > 0) {
				fos.write(buffer);
			}
			fos.close();
			files.add(file);
		}
		return files;
	}

	public File getImage(int image_id) throws SQLException{

		String SQLString = "select * from image where image_id=?;";
		PreparedStatement statement = Connector.prepare(SQLString);
		statement.setInt(1, image_id);
		ResultSet resultSet = statement.executeQuery();

		return null;

	}

}
