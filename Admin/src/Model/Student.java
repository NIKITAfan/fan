package Model;

public class Student {

	private String sid;
	private String sname;
	private int spoint;
	private String smail;
	private String sschool;
	private String sdepartment;
	private String smajor;
	private String sgrade;
	private String sadvantage;
	private String sintroduction;
	//’’∆¨‘ı√¥¥Ê¥¢
	
	public Student(){}

	public Student(String sid, String sname, int spoint, String smail,
			String sschool, String sdepartment, String smajor, String sgrade,
			String sadvantage, String sintroduction) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.spoint = spoint;
		this.smail = smail;
		this.sschool = sschool;
		this.sdepartment = sdepartment;
		this.smajor = smajor;
		this.sgrade = sgrade;
		this.sadvantage = sadvantage;
		this.sintroduction = sintroduction;
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


	public int getSpoint() {
		return spoint;
	}


	public void setSpoint(int spoint) {
		this.spoint = spoint;
	}


	public String getSmail() {
		return smail;
	}


	public void setSmail(String smail) {
		this.smail = smail;
	}


	public String getSschool() {
		return sschool;
	}


	public void setSschool(String sschool) {
		this.sschool = sschool;
	}


	public String getSdepartment() {
		return sdepartment;
	}


	public void setSdepartment(String sdepartment) {
		this.sdepartment = sdepartment;
	}


	public String getSmajor() {
		return smajor;
	}


	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}


	public String getSgrade() {
		return sgrade;
	}


	public void setSgrade(String sgrade) {
		this.sgrade = sgrade;
	}


	public String getSadvantage() {
		return sadvantage;
	}


	public void setSadvantage(String sadvantage) {
		this.sadvantage = sadvantage;
	}


	public String getSintroduction() {
		return sintroduction;
	}


	public void setSintroduction(String sintroduction) {
		this.sintroduction = sintroduction;
	}
	
	
}
