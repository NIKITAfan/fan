package Model;

import java.sql.Date;

public class View_Teacher {
	
	private String uid;
	private String name;
	private int point;
	private String email;
	private String school;
	private String dep;
	private String introduction;
	
	public View_Teacher(){ }

	public View_Teacher(String uid, String name, int point,String email, String school,
			String dep,  String introduction) {
		super();
		this.uid = uid;
		this.name = name;
		this.point = point;  
		this.email=email;  
		this.school = school;  
		this.dep = dep;
		this.introduction = introduction;
		
	}

	public String getuid() {
		return uid;
	}

	public void setuid(String uid) {
		this.uid = uid;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getpoint() {
		return point;
	}

	public void setpoint(int point) {
		this.point = point;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	public String getschool() {
		return school;
	}

	public void setschool(String school) {
		this.school = school;
	}
	
	public String getdep() {
		return dep;
	}

	public void setdep(String dep) {
		this.dep = dep;
	}
	
	
	public String getintrod() {
		return introduction;
	}

	public void setPintrod(String introduction) {
		this.introduction = introduction;
	}

	
	
	
}
