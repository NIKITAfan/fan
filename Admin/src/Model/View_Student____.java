package Model;

public class View_Student____ {

	private String sid;
	private String sname;
	private int pcount;
	private String school;
	private String adv;
	private String adv1;  //¸öÈË¼ò½é
	
	public View_Student____() {
		
	}

	public View_Student____(String sid, String sname, int pcount, String school,String adv, String adv1) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.pcount = pcount;
		this.school = school;  
		this.adv = adv;
		this.adv1 = adv1;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getPcount() {
		return pcount;
	}

	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	
	public String getschool() {
		return school;
	}

	public void setschool(String school) {
		this.school = school;
	}
	public String getadv() {
		return adv;
	}

	public void setadv(String adv) {
		this.adv = adv;
	}
	
	public String getadv1() {
		return adv1;
	}

	public void setadv1(String adv1) {
		this.adv1 = adv1;
	}
	

	
}
