package Model;

public class View_School {
	
	private String school;
	private int num;
	
	
	public View_School(){}

	public View_School(int num,String school) {
		super();
		this.num=num;
		this.school=school;
	}

	public int getnum() {
		return num;
	}

	public void setnum(int num) {
		this.num = num;
	}

	public String getschool() {
		return school;
	}

	public void setschool(String school) {
		this.school = school;
	}
	
	
}
