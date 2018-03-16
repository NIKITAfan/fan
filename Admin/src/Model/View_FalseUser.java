package Model;

public class View_FalseUser {
	private String fuid;
	private String name;
	private String uidentity;
	private String fureason;
	private int funum;
	private String fusituation;
	
	public View_FalseUser()
	{
		
	}

	public View_FalseUser(String fuid,String name, String uidentity, String fureason,
			int funum, String fusituation) {
		super();
		this.fuid = fuid;
		this.name = name;
		this.uidentity = uidentity;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUidentity() {
		return uidentity;
	}

	public void setUidentity(String uidentity) {
		this.uidentity = uidentity;
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
