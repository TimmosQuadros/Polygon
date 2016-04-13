package data;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Facade {

	private BuildingMapper bm;
	private OrganisationMapper om;
	private UserMapper um;
	private ImageMapper im;
	private RoomReportMapper rrm;
	private RoomReportImageMapper rrim;

	public Facade() {
		super();
		this.bm = new BuildingMapper();
		this.om = new OrganisationMapper();
		this.um = new UserMapper();
		this.im = new ImageMapper();
		this.rrm = new RoomReportMapper();
		this.rrim = new RoomReportImageMapper();
	}

	// create
	public void createBuilding(Building b, int id) throws SQLException {
		bm.createBuilding(b, id);
	}

	public void createOrganisation(Organisation o) throws SQLException {
		om.createOrganisation(o);
	}

	public void createUser(User u, String organisation_name) throws SQLException {
		um.createUser(u, organisation_name);
	}

	public void createImage(File file, String image_name) throws SQLException {
		im.createImage(file, image_name);
	}

	// retrieve
	public ArrayList<Building> getAllBuildings() throws SQLException {
		return bm.getBuildings();
	}

	public ArrayList<Building> getUserBuildings(int user_id) throws SQLException {
		return bm.getUserBuildings(user_id);
	}

	public ArrayList<Organisation> getOrganisations() throws SQLException {
		return om.getOrganisations();
	}

	public ArrayList<User> getUsers() throws SQLException {
		return um.getUsers();
	}

	public ArrayList<String> getBuildingFloorplans(int building_id) throws SQLException, IOException {
		return im.getBuildingFloorplans(building_id);
	}
	
	public ArrayList<File> getRoofImages(int report_id) throws SQLException, IOException{
		return im.getRoofImages(report_id);
	}
	
	public ArrayList<File> getOuterWallImages(int report_id) throws SQLException, IOException{
		return im.getOuterWallImages(report_id);
	}
	
	public File getImage(int image_id) throws SQLException{
		return im.getImage(image_id);
	}
	
	public ArrayList<RoomReportImage> getRoomReportImages(int report_id, data.RoomReportImage.Type type) throws SQLException{
		return rrim.getRoomReportImages(report_id, type);
	}
	
	public ArrayList<RoomReportImage> getRoomReportImages(int report_id) throws SQLException{
		return rrim.getRoomReportImages(report_id);
	}

	// update
	public void updateBuilding(Building b) {
		System.out.println("not yet implemented");
	}

	public void updateOrganisation(Organisation o) {
		System.out.println("not yet implemented");
	}

	public void updateUser(User u) {
		System.out.println("not yet implemented");
	}

	public void updateImage() {
		System.out.println("not yet implemented");
	}

	// delete
	public void deleteBuilding(int id) throws SQLException {
		bm.deleteBuilding(id);
	}

	public void deleteOrganisation(int id) {
		System.out.println("not yet implemented");
	}

	public void deleteUser(int id) throws SQLException {
		um.deleteUser(id);
	}

}
