package cn.itcast.domain;

public class Sort {
	private int sid;
	private String sname;
	private double spirce;
	private String sdesc;
	public Sort(int sid, String sname, double spirce, String sdesc) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.spirce = spirce;
		this.sdesc = sdesc;
	}
	public Sort() {}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getSpirce() {
		return spirce;
	}
	public void setSpirce(double spirce) {
		this.spirce = spirce;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	@Override
	public String toString() {
		return "Sort [sid=" + sid + ", sname=" + sname + ", spirce=" + spirce + ", sdesc=" + sdesc + "]";
	}
	
	
}
