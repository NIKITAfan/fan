package Model;

import java.sql.Date;

public class View_StudentProject {
	private int pid;
	private String pname;
	private String srjob;
	private String sccomment;
	private String srreview;
	private int grade;
	private int paiming;
	private int sum;
	public View_StudentProject(){ }

	public View_StudentProject(int pid, String pname, String srjob,String sccomment, String srreview,int grade,int sum,int paiming) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.srjob=srjob;
		this.sccomment=sccomment;
		this.srreview=srreview;
		this.grade=grade;
		this.paiming=paiming;
		this.sum=sum;
		
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getgrade() {
		return grade;
	}

	public void setgrade(int grade) {
		this.grade = grade;
	}
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getsrjob() {
		return srjob;
	}

	public void setsrjob(String srjob) {
		this.srjob = srjob;
	}

	public String getsccomment() {
		return sccomment;
	}

	public void setsccomment(String sccomment) {
		this.sccomment = sccomment;
	}

	public String getsrreview() {
		return srreview;
	}

	public void setsrreview(String srreview) {
		this.srreview = srreview;
	}
	
	public int getpaiming() {
		return paiming;
	}

	public void setpaiming(int paiming) {
		this.paiming = paiming;
	}
	public int getsum() {
		return sum;
	}

	public void setsum(int sum) {
		this.sum = sum;
	}
}
