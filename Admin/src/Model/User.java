package Model;

public class User {
	
	private String uid;
	private String upassword;
	private String uidentity;
	private String ucondition;
	
	public User(){}

	public User(String uid, String upassword, String uidentity, String ucondition) {
		super();
		this.uid = uid;
		this.upassword = upassword;
		this.uidentity = uidentity;
		this.ucondition = ucondition;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUidentity() {
		return uidentity;
	}

	public void setUidentity(String uidentity) {
		this.uidentity = uidentity;
	}

	public String getUcondition() {
		return ucondition;
	}

	public void setUcondition(String ucondition) {
		this.ucondition = ucondition;
	}
	
	
}
