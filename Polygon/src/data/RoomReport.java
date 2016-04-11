package data;

import java.text.SimpleDateFormat;

import org.apache.tomcat.jni.File;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class RoomReport {

	int roomNumber;
	double moistureScanResult;
	String roomDescription, whatIsDamaged, whatIsRepaired, damageType, meassurePoint;
	String wallsRemark, ceilingRemark, floorRemark, windowRemark, doorsRemark;
	String conclusion;
	File wallsImage, ceilingImage, floorImage, windowsImage, doorsImage;
	Boolean damaged, roomRemarks, moistureScan;

	public RoomReport(int roomNumber, double moistureScanResult, String roomDescription, String whatIsDamaged,
			String whatIsRepaired, String damageType, String meassurePoint, String wallsRemark, String ceilingRemark,
			String floorRemark, String windowRemark, String doorsRemark, String conclusion, File wallsImage, File ceilingImage,
			File floorImage, File windowsImage, File doorsImage, Boolean damaged, Boolean roomRemarks,
			Boolean moistureScan) {
		super();
		this.roomNumber = roomNumber;
		this.moistureScanResult = moistureScanResult;
		this.roomDescription = roomDescription;
		this.whatIsDamaged = whatIsDamaged;
		this.whatIsRepaired = whatIsRepaired;
		this.damageType = damageType;
		this.meassurePoint = meassurePoint;
		this.wallsRemark = wallsRemark;
		this.ceilingRemark = ceilingRemark;
		this.floorRemark = floorRemark;
		this.windowRemark = windowRemark;
		this.doorsRemark = doorsRemark;
		this.conclusion = conclusion;
		this.wallsImage = wallsImage;
		this.ceilingImage = ceilingImage;
		this.floorImage = floorImage;
		this.windowsImage = windowsImage;
		this.doorsImage = doorsImage;
		this.damaged = damaged;
		this.roomRemarks = roomRemarks;
		this.moistureScan = moistureScan;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public double getMoistureScanResult() {
		return moistureScanResult;
	}

	public void setMoistureScanResult(double moistureScanResult) {
		this.moistureScanResult = moistureScanResult;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public String getWhatIsDamaged() {
		return whatIsDamaged;
	}

	public void setWhatIsDamaged(String whatIsDamaged) {
		this.whatIsDamaged = whatIsDamaged;
	}

	public String getWhatIsRepaired() {
		return whatIsRepaired;
	}

	public void setWhatIsRepaired(String whatIsRepaired) {
		this.whatIsRepaired = whatIsRepaired;
	}

	public String getDamageType() {
		return damageType;
	}

	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	public String getMeassurePoint() {
		return meassurePoint;
	}

	public void setMeassurePoint(String meassurePoint) {
		this.meassurePoint = meassurePoint;
	}

	public String getWallsRemark() {
		return wallsRemark;
	}

	public void setWallsRemark(String wallsRemark) {
		this.wallsRemark = wallsRemark;
	}

	public String getCeilingRemark() {
		return ceilingRemark;
	}

	public void setCeilingRemark(String ceilingRemark) {
		this.ceilingRemark = ceilingRemark;
	}

	public String getFloorRemark() {
		return floorRemark;
	}

	public void setFloorRemark(String floorRemark) {
		this.floorRemark = floorRemark;
	}

	public String getWindowRemark() {
		return windowRemark;
	}

	public void setWindowRemark(String windowRemark) {
		this.windowRemark = windowRemark;
	}

	public String getDoorsRemark() {
		return doorsRemark;
	}

	public void setDoorsRemark(String doorsRemark) {
		this.doorsRemark = doorsRemark;
	}

	public File getWallsImage() {
		return wallsImage;
	}

	public void setWallsImage(File wallsImage) {
		this.wallsImage = wallsImage;
	}

	public File getCeilingImage() {
		return ceilingImage;
	}

	public void setCeilingImage(File ceilingImage) {
		this.ceilingImage = ceilingImage;
	}

	public File getFloorImage() {
		return floorImage;
	}

	public void setFloorImage(File floorImage) {
		this.floorImage = floorImage;
	}

	public File getWindowsImage() {
		return windowsImage;
	}

	public void setWindowsImage(File windowsImage) {
		this.windowsImage = windowsImage;
	}

	public File getDoorsImage() {
		return doorsImage;
	}

	public void setDoorsImage(File doorsImage) {
		this.doorsImage = doorsImage;
	}

	public Boolean getDamaged() {
		return damaged;
	}

	public void setDamaged(Boolean damaged) {
		this.damaged = damaged;
	}

	public Boolean getRoomRemarks() {
		return roomRemarks;
	}

	public void setRoomRemarks(Boolean roomRemarks) {
		this.roomRemarks = roomRemarks;
	}

	public Boolean getMoistureScan() {
		return moistureScan;
	}

	public void setMoistureScan(Boolean moistureScan) {
		this.moistureScan = moistureScan;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	
}
