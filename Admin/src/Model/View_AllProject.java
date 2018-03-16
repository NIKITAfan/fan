package Model;

public class View_AllProject {
	
	private int pnum;
	private int snum;
	private int ssnum;
	
	
	public View_AllProject(){}

	public View_AllProject(int pnum,int snum,int ssnum) {
		super();
		this.snum=snum;
		this.ssnum=ssnum;
		this.pnum=pnum;
	}

	public int getpnum() {
		return pnum;
	}

	public void setpnum(int pnum) {
		this.pnum = pnum;
	}

	public int getsnum() {
		return snum;
	}

	public void setsnum(int snum) {
		this.snum = snum;
	}
	
	public int getssnum() {
		return ssnum;
	}

	public void setssnum(int ssnum) {
		this.ssnum = ssnum;
	}
	
}
