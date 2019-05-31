
/*
	利用循环，输出字母包含大写小写，52个
	输出A-Z a-zz
	利用编码表实现，字母和数字的对应关系
	A-Z 65-90
	a-z 97-122
	
	
*/




public class LoopTest_2{
	public static void main(String args[]){
		//定义变量，保存2个字母
		char xiaoXie='a';
		char daXie='A';
		
		
		for(int i=0;i<26;i++){
			//输出保存字母的变量
			System.out.println(xiaoXie+" "+daXie);
			xiaoXie++;
			daXie++;
		}
	}
}