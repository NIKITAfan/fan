package Model;

import java.sql.Date;

public class Message {

	private int mid;
	private String muid1;
	private String muid2;
	private String mtext;
	private Date mtime;
	private String msituation;
	
	public Message(){
		super();
	}

	public Message(int mid, String muid1, String muid2, String mtext,
			Date mtime, String msituation) {
		super();
		this.mid = mid;
		this.muid1 = muid1;
		this.muid2 = muid2;
		this.mtext = mtext;
		this.mtime = mtime;
		this.msituation = msituation;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMuid1() {
		return muid1;
	}

	public void setMuid1(String muid1) {
		this.muid1 = muid1;
	}

	public String getMuid2() {
		return muid2;
	}

	public void setMuid2(String muid2) {
		this.muid2 = muid2;
	}

	public String getMtext() {
		return mtext;
	}

	public void setMtext(String mtext) {
		this.mtext = mtext;
	}

	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	public String getMsituation() {
		return msituation;
	}

	public void setMsituation(String msituation) {
		this.msituation = msituation;
	}
	
	
}
