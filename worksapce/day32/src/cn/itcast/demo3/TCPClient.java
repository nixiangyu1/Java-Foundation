package cn.itcast.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class TCPClient {
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("192.168.56.1",8888);
		OutputStream out = socket.getOutputStream();
		out.write("服务器OK".getBytes());
		
		//读取服务器发回的数据
		InputStream in = socket.getInputStream();
		byte[] data = new byte[1024];
		int len=in.read(data);
		System.out.println(new String(data,0,len));
		socket.close();
	}
}
