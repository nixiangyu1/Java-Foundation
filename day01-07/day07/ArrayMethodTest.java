/*
	���巽����ʵ������ı���
	�����У�������[11,33.565,66,78,89]
	int[] arr={3,4,45,7};
	��������ַ�����[].
	ʵ�ֲ���:
		1.���巽��ʵ������ı���
		2.�ȴ�ӡ[������
		3.��������
			��������Ԫ�غͶ���
			�ж��Ƿ����������������һ��Ԫ�أ���������һ��Ԫ�أ�����Ӧ����
*/
public class ArrayMethodTest{
	public static void main(String args[]){
		int [] arr={11,22,33,44,55};
		printArray(arr);
		
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

	