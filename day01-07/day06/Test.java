/*
	���������
	  ͬʱ���ԣ��緹����ѧ��������

*/

public class Test{
	public static void main(String args[]){
		//�����緹������������
		DianFanGuo dfg=new DianFanGuo();
		
		dfg.brand="��˹��";
		dfg.colour="��ɫ";
		dfg.size=30;
		
		System.out.println(dfg.brand+" "+dfg.colour+" "+dfg.size);
		
		//������������
		Car c=new Car();
		c.brand="��������";
		c.type="����";
		c.paiLiang=0.5;
		
		System.out.println(c.brand+" "+c.type+" "+c.paiLiang);
	}
}