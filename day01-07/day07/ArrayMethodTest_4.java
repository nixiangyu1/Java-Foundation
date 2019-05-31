/*
	������۰����
*/

import java.util.Scanner;




public class ArrayMethodTest_4{
	public static void main(String args[]){
		int[] arr={55,123,24,23,3,5,6};
		//����ð�����򷽷�
		bubbleSort(arr);
		//���ô�ӡ����
		printArray(arr);
		System.out.println();
		System.out.println("��������Ҫ���ҵ�������������������еĻ���ϵͳ�᷵�������±�");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int index=binarySearch(arr,n);
		System.out.println(index);
	
	}
	
	/*
		���巽����ʵ�֣��۰����
		����ֵ������
		���������飬���ҵ�Ԫ��
		ʵ�ֲ��裺
			1.��Ҫ�ı�������
				����ָ��
			2.����ѭ���۰�
				�����۰������ min<=max
			3.�ñ��ҵ�Ԫ�أ����м�����Ԫ�ؽ��бȽ�
				Ԫ�ش����м�����  min=mid+1
				Ԫ��С���м�����  max=mid-1
				Ԫ�ص����м�����  �ҵ��ˣ������ˣ������м�����
			4.ѭ���������޷��۰�
				Ԫ��û���ҵ�������-1
		
	*/
	public static int binarySearch(int[] arr,int key){
		//��������ָ�����
		int min=0;
		int max=arr.length-1;
		int mid=0;
		//ѭ���۰룬���� min<=max
		while(min<=max){
			//��ʽ�������м�����
			mid=(min+max)/2;
			//�ñ���Ԫ�غ��м�Ԫ�ؽ��бȽ�
			if(key>arr[mid]){
				min=mid+1;
			}else if(key<arr[mid]){
				max=mid-1;
			}else if(key==arr[mid]){
				//�ҵ�Ԫ�أ�����mid����
				return mid;
			}
			
		}
		return -1;
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