/*
  ���������: һ�㶼����������,Ԫ��,С���������
  
  ��������ķ�ʽ
     ѡ������: �����ÿ��Ԫ�ض����бȽ�
	 ð������: ����������Ԫ�ؽ��бȽ�
	 ����: �Ƚϴ�С,λ�ý���
*/






public class ArrayMethodTest_3{
	public static void main(String args[]){
		int[] arr={55,123,24,23,3,5,6};
		//����ð�����򷽷�
		bubbleSort(arr);
		//���ô�ӡ����
		printArray(arr);
	
	}
	
	
	/*
		���巽����ʵ�������ð������
		����ֵ��û��
		����:���������
		
				
	*/
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			//ÿ����ѭ���ıȽϣ���0��ʼ
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					
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