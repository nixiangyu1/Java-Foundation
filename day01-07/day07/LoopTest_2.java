
/*
	����ѭ���������ĸ������дСд��52��
	���A-Z a-zz
	���ñ����ʵ�֣���ĸ�����ֵĶ�Ӧ��ϵ
	A-Z 65-90
	a-z 97-122
	
	
*/




public class LoopTest_2{
	public static void main(String args[]){
		//�������������2����ĸ
		char xiaoXie='a';
		char daXie='A';
		
		
		for(int i=0;i<26;i++){
			//���������ĸ�ı���
			System.out.println(xiaoXie+" "+daXie);
			xiaoXie++;
			daXie++;
		}
	}
}