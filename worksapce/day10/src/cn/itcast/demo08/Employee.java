package cn.itcast.demo08;
/*
 * ����Ա����
 * 		���ݣ�������������Ĺ��Գ�ȡ
 * 			����:����������
 * 			����������
 */
public abstract class Employee {
		//�����Ա��������
	private String name;
	//�����Ա��������
	private String Id;
	
	//���幤������
	public abstract void work();
	
	public void setName(String name) {
		this.name=name;
	}
	public void setId(String Id) {
		this.Id=Id;
	}
	public String getName() {
		return this.name;
	}
	public String getId() {
		return this.Id;
	}
	
}
