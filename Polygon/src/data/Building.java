package data;

class Building {
		
	String building_name, street_address;
	int building_id, zip, build_year, floor_area;
	
	public Building(String building_name, String street_address, int building_id, int zip, int build_year,
			int floor_area) {
		super();
		this.building_name = building_name;
		this.street_address = street_address;
		this.building_id = building_id;
		this.zip = zip;
		this.build_year = build_year;
		this.floor_area = floor_area;
	}

	public int getBuild_year() {
		return build_year;
	}

	public void setBuild_year(int build_year) {
		this.build_year = build_year;
	}

	public int getFloor_area() {
		return floor_area;
	}

	public void setFloor_area(int floor_area) {
		this.floor_area = floor_area;
	}

	public Building(String building_name, String street_address, int building_id, int zip) {
		super();
		this.building_name = building_name;
		this.street_address = street_address;
		this.building_id = building_id;
		this.zip = zip;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(int building_id) {
		this.building_id = building_id;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

}
