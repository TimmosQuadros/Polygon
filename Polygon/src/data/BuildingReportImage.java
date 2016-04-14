package data;

import java.io.File;

public class BuildingReportImage {

	private int image_id;
	private int report_id;
	public enum Type{ROOF,OUTER_WALL};
	public Type type;
	public File image;
	
	public BuildingReportImage(int image_id, int report_id, Type type,File image) {
		super();
		this.image_id = image_id;
		this.report_id = report_id;
		this.type = type;
		this.image = image;
	}
	
	

	public File getImage() {
		return image;
	}



	public void setImage(File image) {
		this.image = image;
	}



	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
	
	
	
}
