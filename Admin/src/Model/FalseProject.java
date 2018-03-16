package Model;

public class FalseProject {
	private int fpid;
	private String fpreason;
	private int  fpnum;
	private String fpsituation;
	
	public FalseProject()
	{
		
	}

	public FalseProject(int fpid, String fpreason, int fpnum, String fpsituation) {
		super();
		this.fpid = fpid;
		this.fpreason = fpreason;
		this.fpnum = fpnum;
		this.fpsituation = fpsituation;
	}

	@Override
	public String toString() {
		return "FalseProject [fpid=" + fpid + ", fpreason=" + fpreason + ", fpnum=" + fpnum + ", fpsituation="
				+ fpsituation + "]";
	}

	public int getFpid() {
		return fpid;
	}

	public void setFpid(int fpid) {
		this.fpid = fpid;
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

}
