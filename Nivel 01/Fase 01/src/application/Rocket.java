package application;

public class Rocket {

	private int num;
	private String id;
	private int enginesNum;
	
	public Rocket(int num, String id, int enginesNum) {
		this.num = num;
		this.id = id;
		this.enginesNum = enginesNum;
	}
	
	private static int COUNTER_MEMBERS = 1;
	
	public Rocket(String id) throws Exception {
		if (id.equals(""))
			throw new Exception();

		this.id = id;
		num = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
	}
	
	public int getnum() {
		return num;
	}
	
	public String getid() {
		return id;
	}

	public int getenginesNum() {
		return enginesNum;
	}

	public static void main(String[] args) {}
	
}
