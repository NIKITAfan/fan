package Model;

public class Stu_Project {

	private String spsid;
	private int sppid;
	private String spsituation;
	
	public Stu_Project() {}

	public Stu_Project(String spsid, int sppid, String spsituation) {
		super();
		this.spsid = spsid;
		this.sppid = sppid;
		this.spsituation = spsituation;
	}

	public String getSpsid() {
		return spsid;
	}

	public void setSpsid(String spsid) {
		this.spsid = spsid;
	}

	public int getSppid() {
		return sppid;
	}

	public void setSppid(int sppid) {
		this.sppid = sppid;
	}

	public String getSpsituation() {
		return spsituation;
	}

	public void setSpsituation(String spsituation) {
		this.spsituation = spsituation;
	}
	
	
}
