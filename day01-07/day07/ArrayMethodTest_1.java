/*
	���������
	�����е�Ԫ�أ�����λ���ϵĽ���
	���� ������ �������
	������������Զ����������������λ�ý�����ʵ�����������
	ʹ�õ��������ָ��˼�룬���Ǳ�����
	��ת reverse
	
*/

public class ArrayMethodTest_1{
	public static void main(String args[]){
		int[] arr={1,2,3,4};
		reverse(arr);
		printArray(arr);
	
	}


	/*
		���巽����ʵ�����������
		����ֵ��û�з���ֵ
		����������
		
	*/
	
	public static void reverse(int[] arr){
		//ѭ������
		for(int min=0,max=arr.length-1;min<max;min++,max--){
			//�������е�Ԫ�ؽ���λ�ý���
			//min������max������Ԫ�ؽ���
			//�����������Ϊ��ʱ����
			int temp=arr[min];
			arr[min]=arr[max];
			arr[max]=temp;
			
		}
		
	}
	
	/*
		���巽����ʵ�ֹ���
		����ֵ:void
		��������������
	*/
	public static void printArray(int[] arr){
		//���������ţ���Ҫ����
		System.out.print("[");
		//�������
		for(int i=0;i<arr.length;i++){
			//�ж������ǲ������һ��Ԫ��
			if(i==arr.length-1){
				System.out.print(arr[i]+"]");
				
			}else{
				System.out.print(arr[i]+",");
			}
			
		}
		
	}
}