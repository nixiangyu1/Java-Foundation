package cn.itcast.demo01;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
		//File��ľ�̬��Ա����
		//��ϵͳ�йص�·������
		String separator=File.pathSeparator;	
		System.out.println(separator);
		
		//
		separator=File.separator;
		System.out.println(separator);
	}
}
