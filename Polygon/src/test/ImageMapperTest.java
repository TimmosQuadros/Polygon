package test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import data.ImageMapper;

public class ImageMapperTest {
	ImageMapper img;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		img = new ImageMapper();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws SQLException, IOException {
		//img.createImage(new File("C:/Users/TimmosQuadros/Desktop/floor_plan_example.png"),"Floorplan");
		
		img.getUserImages(1);
	}

}
