package cn.itcast.demo03;

public abstract class Employee {
	private String name;
	private String ID;
	public abstract void work();
	
	public Employee(String name,String ID) {
		this.name=name;
		this.ID=ID;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setID(String ID) {
		this.ID=ID;
	}
	public String getID() {
		return this.ID;
	}
}
