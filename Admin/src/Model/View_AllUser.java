package Model;

public class View_AllUser {
	
	private int unum;
	private int snum;
	private int tnum;
	
	
	public View_AllUser(){}

	public View_AllUser(int unum,int snum,int tnum) {
		super();
		this.snum=snum;
		this.tnum=tnum;
		this.unum=unum;
	}

	public int getunum() {
		return unum;
	}

	public void setunum(int unum) {
		this.unum = unum;
	}

	public int getsnum() {
		return snum;
	}

	public void setsnum(int snum) {
		this.snum = snum;
	}
	
	public int gettnum() {
		return tnum;
	}

	public void settnum(int tnum) {
		this.tnum = tnum;
	}
	
}
