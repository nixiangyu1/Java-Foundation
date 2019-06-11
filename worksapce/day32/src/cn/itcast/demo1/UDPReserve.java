package cn.itcast.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReserve {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(6000);
		byte[] data = new byte[1024];
		while(true) {
		DatagramPacket dp = new DatagramPacket(data, data.length);
		ds.receive(dp);
		//获取发送端的IP地址对象
		String ip=dp.getAddress().getHostAddress();
		int port=dp.getPort();
		int length =dp.getLength();
		System.out.println(new String(data,0,length)+".."+ip+":"+port);
		}
//		ds.close();
	}
}
