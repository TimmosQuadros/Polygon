package data;

import java.io.File;

public class RoomReportImage {
	
	private int report_id;
	
	private int image_id;
	
	public enum Type {FLOOR,CEILING,WALL,DOOR,WINDOW};
	Type type;
	File image;
	
	public RoomReportImage(int report_id, int image_id, File image, Type type) {
		super();
		this.report_id = report_id;
		this.image_id = image_id;
		this.image = image;
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}
	
	
	
	
	

}
