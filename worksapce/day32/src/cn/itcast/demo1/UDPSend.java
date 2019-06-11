package cn.itcast.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSend {
	public static void main(String[] args) throws IOException {
		//
		Scanner sc = new Scanner(System.in);
		DatagramSocket ds = new DatagramSocket();  
		InetAddress inet = InetAddress.getByName("192.168.56.1");
		while(true) {
		String message = sc.nextLine();
		byte[] data = message.getBytes();
		//创建InetAddress对象，封装自己的IP地址
		DatagramPacket dp = new DatagramPacket(data, data.length,inet,6000);
		//创建
		ds.send(dp);
		System.out.println(new String(data));
		}
//		ds.close();
	}
}
