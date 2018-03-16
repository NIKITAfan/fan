package Model;

public class View_FalseProject {

	private int pid;
	private String pname;
	private String tname;
	private String  fpreason;
	private int fpnum;
	private String fpsituation;
	
	public View_FalseProject()
	{
		super();		
	}

	public View_FalseProject(int pid,String pname, String tname, String fpreason,
			int fpnum, String fpsituation) {
		this.pid=pid;
		this.pname = pname;
		this.tname = tname;
		this.fpreason = fpreason;
		this.fpnum = fpnum;
		this.fpsituation = fpsituation;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getFpreason() {
		return fpreason;
	}

	public void setFpreason(String fpreason) {
		this.fpreason = fpreason;
	}

	public int getFpnum() {
		return fpnum;
	}

	public void setFpnum(int fpnum) {
		this.fpnum = fpnum;
	}

	public String getFpsituation() {
		return fpsituation;
	}

	public void setFpsituation(String fpsituation) {
		this.fpsituation = fpsituation;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
}
