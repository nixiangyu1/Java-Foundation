/*
	���������:һ�㶼����������Ԫ�أ�С���������
	
	
	��������ʽ
		ѡ�����������ÿ��Ԫ�ض����бȽ�
		ð����������������Ԫ�ؽ��бȽ�
		����:�Ƚϴ�С��λ�ý���
*/





public class ArrayMethodTest_2{
	public static void main(String args[]){
		int[] arr={55,123,24,23,3,5,6};
		//����ѡ�����򷽷�
		selectSort(arr);
		//���ô�ӡ����
		printArray(arr);
	
	}
	
	
	/*
		���巽����ʵ�������ѡ������
		����ֵ��û��
		����:���������
		ʵ�ֲ���:
			1.Ƕ��ѭ��ʵ������
				��ѭ�������Ƶ���һ���Ƚ϶��ٴ�
				��ѭ�������Ƶ���ÿ�αȽ��˶��ٸ�Ԫ��
			2.�ж�Ԫ�صĴ�Сֵ
			  Сֵ���洢��С������
				
	*/
	public static void selectSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				//�����Ԫ�ؽ����ж�
				if(arr[i]>arr[j]){
					//���黻λ
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
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