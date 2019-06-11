package cn.itcast.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * �������е�ip��ַ
 * 	java.net.InetAddress
 * ��̬����
 * 	static InetAddress getLocalHost()  ��������
 * 	���ر�������������ֵInetAddress����
 * 
 * 	static InetAddress getByName(String hostName)��������������ȡIP��ַ����
 * 
 * 	
 * �Ǿ�̬����
 *   String getHoustAddress()��ȡ����IP��ַ
 *   String getHoustName() ��ȡ������
 *   
 */
public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		function();
	}
	//static InetAddress getByName(String hostName)��������������ȡIP��ַ����
	public static void function_1() throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("LAPTOP-VCHODBPN");
		
	}
	
	
	
	//static InetAddress getLocalHost()  ��������
	public static void function() throws UnknownHostException {
		InetAddress inet=InetAddress.getLocalHost();
		//��������������������IP��ַ
		System.out.println(inet);
		
		String ip = inet.getHostAddress();
		String name =inet.getHostName();
		System.out.println(ip+"  "+name);
//		String host =inet.toString();
//		String[] str = host.split("/");
//		for(String s:str) {
//			System.out.println(s);
//		}
	}
}
