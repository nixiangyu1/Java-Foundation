/*
   ��ά����ı���
*/
import java.util.Random;
public class ArrayArrayDemo_2{
	public static void main(String args[]){
		String[] names={"������","������","����","������"};
		
		//��������
		for(int i=0;i<names.length;i++){
			System.out.println(names[i]);
		}
		
		
		//�ָ���
		System.out.println("=========");
		
		Random ran=new Random();
		int index=ran.nextInt(names.length);
		System.out.println(names[index]);
		
		
	}
}