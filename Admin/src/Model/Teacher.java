package Model;

public class Teacher {

	private String tid;
	private String tname;
	private int tpoint;
	private String tmail;
	private String tschool;
	private String tdepartment;
	private String tintroduction;	
	//ͼƬ
	
	public Teacher() {}
	public Teacher(String tid, String tname, int tpoint, String tmail,
			String tschool, String tdepartment, String tintroduction) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tpoint = tpoint;
		this.tmail = tmail;
		this.tschool = tschool;
		this.tdepartment = tdepartment;
		this.tintroduction = tintroduction;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTpoint() {
		return tpoint;
	}
	public void setTpoint(int tpoint) {
		this.tpoint = tpoint;
	}
	public String getTmail() {
		return tmail;
	}
	public void setTmail(String tmail) {
		this.tmail = tmail;
	}
	public String getTschool() {
		return tschool;
	}
	public void setTschool(String tschool) {
		this.tschool = tschool;
	}
	public String getTdepartment() {
		return tdepartment;
	}
	public void setTdepartment(String tdepartment) {
		this.tdepartment = tdepartment;
	}
	public String getTintroduction() {
		return tintroduction;
	}
	public void setTintroduction(String tintroduction) {
		this.tintroduction = tintroduction;
	}
	
	
	
}
