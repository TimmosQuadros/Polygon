package data;

public class RoomConclusion {
	String RoomIdentifer;
	String Conclusion;
	
	public RoomConclusion(String roomIdentifer, String conclusion) {
		super();
		RoomIdentifer = roomIdentifer;
		Conclusion = conclusion;
	}

	public String getRoomIdentifer() {
		return RoomIdentifer;
	}

	public void setRoomIdentifer(String roomIdentifer) {
		RoomIdentifer = roomIdentifer;
	}

	public String getConclusion() {
		return Conclusion;
	}

	public void setConclusion(String conclusion) {
		Conclusion = conclusion;
	}
	
	
}
