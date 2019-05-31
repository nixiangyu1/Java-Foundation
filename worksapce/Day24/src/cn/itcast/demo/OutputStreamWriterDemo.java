package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {

	public static void main(String[] args) throws IOException {
		writeGBK();
		WriteUTF();
	}
	/*
	 * ת��������OutputStreamWriterд�ı�
	 * ����UTF-8�����д��
	 */
	public static void WriteUTF() throws IOException {
		FileOutputStream fos = new FileOutputStream("e:\\utf.txt");
		OutputStreamWriter osw= new OutputStreamWriter(fos, "UTF-8");
		osw.write("���");
		osw.flush();
		osw.close();
	}
	
	public static void writeGBK() throws IOException {
		//�����ֽ���������������ļ�
		FileOutputStream fos =new FileOutputStream("e:\\abc.txt");
		//����ת�������󣬹��췽�������ֽ������,ʹ��GBK���
		OutputStreamWriter osw= new OutputStreamWriter(fos);
		//ת����д����
		osw.write("���");
		osw.flush();
		osw.close();
	}
}
