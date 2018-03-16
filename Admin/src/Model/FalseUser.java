package Model;

public class FalseUser {
	private String fuid;
	private String fureason;
	private int  funum;
	private String fusituation;
	
	public FalseUser() {}

	public FalseUser(String fuid, String fureason, int funum, String fusituation) {
		super();
		this.fuid = fuid;
		this.fureason = fureason;
		this.funum = funum;
		this.fusituation = fusituation;
	}

	public String getFuid() {
		return fuid;
	}

	public void setFuid(String fuid) {
		this.fuid = fuid;
	}

	public String getFureason() {
		return fureason;
	}

	public void setFureason(String fureason) {
		this.fureason = fureason;
	}

	public int getFunum() {
		return funum;
	}

	public void setFunum(int funum) {
		this.funum = funum;
	}

	public String getFusituation() {
		return fusituation;
	}

	public void setFusituation(String fusituation) {
		this.fusituation = fusituation;
	}

	
	
}
