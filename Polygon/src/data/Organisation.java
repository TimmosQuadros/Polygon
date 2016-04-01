package data;

public class Organisation {
	
	int id;
	String name;

	public Organisation(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Organisation(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
