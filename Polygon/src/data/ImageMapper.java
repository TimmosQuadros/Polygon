package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
