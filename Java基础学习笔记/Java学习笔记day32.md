#### 32.1网络编程



![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml15972\wps1.jpg)

​                                                     TCP/IP网络模型

链路层：[链路层](http://zhidao.baidu.com/search?word=%CA%FD%BE%DD%C1%B4%C2%B7%B2%E3&fr=qb_search_exp&ie=gbk)是用于定义物理传输通道，通常是对某些网络连接设备的驱动协议，例如针对光纤、[网线](http://zhidao.baidu.com/search?word=%CB%AB%BD%CA%CF%DF&fr=qb_search_exp&ie=gbk)提供的驱动。

网络层：网络层是整个TCP/IP协议的核心，它主要用于将传输的数据进行分组，将分组数据发送到目标计算机或者网络。

传输层：主要使网络程序进行通信，在进行网络通信时，可以采用TCP协议，也可以采用UDP协议。

应用层：主要负责应用程序的协议，例如HTTP协议、FTP协议等。

##### 32.1.1网络通讯协议

###### 1.地址和端口号

要想使网络中的计算机能够进行通信，必须为每台计算机指定一个标识号，通过这个标识号来指定接受数据的计算机或者发送数据的计算机。

在TCP/IP协议中，这个标识号就是IP地址，它可以唯一标识一台计算机，目前，IP地址广泛使用的版本是IPv4，它是由4个字节大小的二进制数来表示，如：00001010000000000000000000000001。由于二进制形式表示的IP地址非常不便记忆和处理，因此通常会将IP地址写成十进制的形式，每个字节用一个十进制数字(0-255)表示，数字间用符号“.”分开，如 “192.168.1.100”。

随着计算机网络规模的不断扩大，对IP地址的需求也越来越多，IPV4这种用4个字节表示的IP地址面临枯竭，因此IPv6 便应运而生了，IPv6使用16个字节表示IP地址，它所拥有的地址容量约是IPv4的8×1028倍，达到2128个（算上全零的），这样就解决了网络地址资源数量不够的问题。

通过IP地址可以连接到指定计算机，但如果想访问目标计算机中的某个应用程序，还需要指定端口号。在计算机中，不同的应用程序是通过端口号区分的。端口号是用两个字节（16位的二进制数）表示的，它的取值范围是0~65535，其中，0~1023之间的端口号用于一些知名的网络服务和应用，用户的普通应用程序需要使用1024以上的端口号，从而避免端口号被另外一个应用或服务所占用。

接下来通过一个图例来描述IP地址和端口号的作用，如下图所示。

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml15972\wps3.png) 

从上图中可以清楚地看到，位于网络中一台计算机可以通过IP地址去访问另一台计算机，并通过端口号访问目标计算机中的某个应用程序。

###### 2.InetAddress

~~~java
package cn.itcast.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * 互联网中的ip地址
 * 	java.net.InetAddress
 * 静态方法
 * 	static InetAddress getLocalHost()  本地主机
 * 	返回本地主机，返回值InetAddress对象
 * 
 * 	static InetAddress getByName(String hostName)传递主机名，获取IP地址对象
 * 
 * 	
 * 非静态方法
 *   String getHoustAddress()获取主机IP地址
 *   String getHoustName() 获取主机名
 *   
 */
public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		function();
	}
	//static InetAddress getByName(String hostName)传递主机名，获取IP地址对象
	public static void function_1() throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("LAPTOP-VCHODBPN");
		
	}
	
	
	
	//static InetAddress getLocalHost()  本地主机
	public static void function() throws UnknownHostException {
		InetAddress inet=InetAddress.getLocalHost();
		//输出结果就是主机名，和IP地址
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
~~~

##### 32.1.2UDP与TCP协议

###### 1.UDP协议

UDP是无连接通信协议，即在数据传输时，数据的发送端和接收端不建立逻辑连接。简单来说，当一台计算机向另外一台计算机发送数据时，发送端不会确认接收端是否存在，就会发出数据，同样接收端在收到数据时，也不会向发送端反馈是否收到数据。

由于使用UDP协议消耗资源小，通信效率高，所以通常都会用于音频、视频和普通数据的传输例如视频会议都使用UDP协议，因为这种情况即使偶尔丢失一两个数据包，也不会对接收结果产生太大影响。

但是在使用UDP协议传送数据时，由于UDP的面向无连接性，不能保证数据的完整性，因此在传输重要数据时不建议使用UDP协议。UDP的交换过程如下图所示。

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml15972\wps4.png)

###### 2.TCP协议

TCP协议是面向连接的通信协议，即在传输数据前先在发送端和接收端建立逻辑连接，然后再传输数据，它提供了两台计算机之间可靠无差错的数据传输。在TCP连接中必须要明确客户端与服务器端，由客户端向服务端发出连接请求，每次连接的创建都需要经过“三次握手”。第一次握手，客户端向服务器端发出连接请求，等待服务器确认，第二次握手，服务器端向客户端回送一个响应，通知客户端收到了连接请求，第三次握手，客户端再次向服务器端发送确认信息，确认连接。整个交互过程如下图所示。

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml15972\wps5.png) 

由于TCP协议的面向连接特性，它可以保证传输数据的安全性，所以是一个被广泛采用的协议，例如在下载文件时，如果数据接收不完整，将会导致文件数据丢失而不能被打开，因此，下载文件时必须采用TCP协议。

##### 32.1.3UDP通信

~~~java
package cn.itcast.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 *  实现UDP协议的发送端:
 *    实现封装数据的类 java.net.DatagramPacket  将你的数据包装
 *    实现数据传输的类 java.net.DatagramSocket  将数据包发出去
 *    
 *  实现步骤:
 *    1. 创建DatagramPacket对象,封装数据, 接收的地址和端口
 *    2. 创建DatagramSocket
 *    3. 调用DatagramSocket类方法send,发送数据包
 *    4. 关闭资源
 *    
 *    DatagramPacket构造方法:
 *      DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
 *      
 *    DatagramSocket构造方法:
 *      DatagramSocket()空参数
 *      方法: send(DatagramPacket d)
 *      
 */
public class UDPSend {
	public static void main(String[] args) throws IOException{
		//创建数据包对象,封装要发送的数据,接收端IP,端口
		byte[] date = "你好UDP".getBytes();
		//创建InetAddress对象,封装自己的IP地址
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket dp = new DatagramPacket(date, date.length, inet,6000);
		//创建DatagramSocket对象,数据包的发送和接收对象
		DatagramSocket ds = new DatagramSocket();
		//调用ds对象的方法send,发送数据包
		ds.send(dp);
		//关闭资源
		ds.close();
	}
}
~~~

~~~java
package cn.itcast.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 *  实现UDP接收端
 *    实现封装数据包 java.net.DatagramPacket 将数据接收
 *    实现输出传输     java.net.DatagramSocket 接收数据包
 *    
 *  实现步骤:
 *     1. 创建DatagramSocket对象,绑定端口号
 *         要和发送端端口号一致
 *     2. 创建字节数组,接收发来的数据
 *     3. 创建数据包对象DatagramPacket
 *     4. 调用DatagramSocket对象方法
 *        receive(DatagramPacket dp)接收数据,数据放在数据包中
 *     5. 拆包
 *          发送的IP地址
 *            数据包对象DatagramPacket方法getAddress()获取的是发送端的IP地址对象
 *            返回值是InetAddress对象
 *          接收到的字节个数
 *            数据包对象DatagramPacket方法 getLength()
 *          发送方的端口号
 *            数据包对象DatagramPacket方法 getPort()发送端口
 *     6. 关闭资源
 */
public class UDPReceive {
	public static void main(String[] args)throws IOException {
		//创建数据包传输对象DatagramSocket 绑定端口号
		DatagramSocket ds = new DatagramSocket(6000);
		//创建字节数组
		byte[] data = new byte[1024];
		//创建数据包对象,传递字节数组
		DatagramPacket dp = new DatagramPacket(data, data.length);
		//调用ds对象的方法receive传递数据包
		ds.receive(dp);
		
		//获取发送端的IP地址对象
		String ip=dp.getAddress().getHostAddress();
		
		//获取发送的端口号
		int port = dp.getPort();
		
		//获取接收到的字节个数
		int length = dp.getLength();
		System.out.println(new String(data,0,length)+"..."+ip+":"+port);
		ds.close();
	}
}
~~~

键盘录入

~~~java
package cn.itcast.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
 * 实现UDP发送,键盘输入的形式
 * 输入完毕,发送给接收端      
 */
public class UDPSend {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		DatagramSocket ds = new DatagramSocket();
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		while(true){
		String message = sc.nextLine();
		/*if("886".equals(message)){
			break;
		}*/
		byte[] date = message.getBytes();
		DatagramPacket dp = new DatagramPacket(date, date.length, inet,6000);
		ds.send(dp);
		}
	//	ds.close();
	}
}

~~~

~~~java
package cn.itcast.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 *  实现UDP接收端
 *  永不停歇的接收端
 */
public class UDPReceive {
	public static void main(String[] args)throws IOException {
		//创建数据包传输对象DatagramSocket 绑定端口号
		DatagramSocket ds = new DatagramSocket(6000);
		//创建字节数组
		byte[] data = new byte[1024];
		//创建数据包对象,传递字节数组
		while(true){
		DatagramPacket dp = new DatagramPacket(data, data.length);
		//调用ds对象的方法receive传递数据包
		ds.receive(dp);
		
		//获取发送端的IP地址对象
		String ip=dp.getAddress().getHostAddress();
		
		//获取发送的端口号
		int port = dp.getPort();
		
		//获取接收到的字节个数
		int length = dp.getLength();
		System.out.println(new String(data,0,length)+"..."+ip+":"+port);
		}
		//ds.close();
	}
}
~~~

##### 32.1.4TCP通信

~~~java
package cn.itcast.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 *  实现TCP客户端,连接到服务器
 *  和服务器实现数据交换
 *  实现TCP客户端程序的类 java.net.Socket
 *  
 *  构造方法:
 *      Socket(String host, int port)  传递服务器IP和端口号
 *      注意:构造方法只要运行,就会和服务器进行连接,连接失败,抛出异常
 *      
 *    OutputStream  getOutputStream() 返回套接字的输出流
 *      作用: 将数据输出,输出到服务器
 *      
 *    InputStream getInputStream() 返回套接字的输入流
 *      作用: 从服务器端读取数据
 *      
 *    客户端服务器数据交换,必须使用套接字对象Socket中的获取的IO流,自己new流,不行
 */
public class TCPClient {
	public static void main(String[] args)throws IOException {
		//创建Socket对象,连接服务器
		Socket socket = new Socket("127.0.0.1", 8888);
		//通过客户端的套接字对象Socket方法,获取字节输出流,将数据写向服务器
		OutputStream out = socket.getOutputStream();
		out.write("服务器OK".getBytes());
		
		//读取服务器发回的数据,使用socket套接字对象中的字节输入流
		InputStream in = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = in.read(data);
		System.out.println(new String(data,0,len));
		
		socket.close();
	}
}

~~~

~~~java
package cn.itcast.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 *  实现TCP服务器程序
 *  表示服务器程序的类 java.net.ServerSocket
 *  构造方法:
 *    ServerSocket(int port) 传递端口号
 *  
 *  很重要的事情: 必须要获得客户端的套接字对象Socket
 *    Socket  accept()
 */
public class TCPServer {
	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(8888);
		//调用服务器套接字对象中的方法accept() 获取客户端套接字对象
		Socket socket = server.accept();
		//通过客户端套接字对象,socket获取字节输入流,读取的是客户端发送来的数据
		InputStream in = socket.getInputStream();
		byte[] data = new byte[1024];
		int len = in.read(data);
		System.out.println(new String(data,0,len));
		
		//服务器向客户端回数据,字节输出流,通过客户端套接字对象获取字节输出流
		OutputStream out = socket.getOutputStream();
		out.write("收到,谢谢".getBytes());
		
		socket.close();
		server.close();
	}
}
~~~

##### 32.1.5TCP的中的流对象

![1560172675365](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1560172675365.png)

##### 32.1.6TCP图片上传案例分析

![1560172848633](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1560172848633.png)

~~~java
package cn.itcast.demo4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 实现TCP图片上传客户端
 * 实现步骤:
 * 	1.Socket套接字连接服务器
 * 	2.通过Socket获取字节输出流，写图片
 * 	3.使用自己的流对象，读取图片数据源
 * 		FileInputStream
 * 	4.读取图片，使用字节输出流，将图片写到服务器
 * 	5.通过Socket套接字获取字节输入流
 * 		读取服务器放回来的上传成功
 * 	6.关闭资源 
 * 
 */
public class TCClient {
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("192.168.56.1",8888);
		//获取字节输出流，图片写到服务器
		OutputStream out = socket.getOutputStream();
		//创建字节输入流，读取本机上的数据源文件
		FileInputStream fis = new FileInputStream("E:\\c.jpg");
		//开始读写字节数组
		int len = 0;
		byte[] bytes = new byte[1024];
		while((len=fis.read(bytes))!=-1) {
			out.write(bytes, 0, len);
		}
		//给服务器写终止序列
		socket.shutdownOutput();
		//获取字节输入流，读取服务器的上传成功
		InputStream in = socket.getInputStream();
		len = in.read(bytes);
		System.out.println(new String(bytes,0,len));
		
		fis.close();
		socket.close();
	}
}
~~~

~~~java
package cn.itcast.demo4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*   TCP图片上传服务器
 *   1. ServerSocket套接字对象,监听端口8000
 *   2. 方法accept()获取客户端的连接对象
 *   3. 客户端连接对象获取字节输入流,读取客户端发送图片
 *   4. 创建File对象,绑定上传文件夹
 *       判断文件夹存在, 不存,在创建文件夹
 *   5. 创建字节输出流,数据目的File对象所在文件夹
 *   6. 字节流读取图片,字节流将图片写入到目的文件夹中
 *   7. 将上传成功会写客户端
 *   8. 关闭资源
 */
public class TCPServer {
	public static void main(String[] args)  throws IOException{
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		//通过客户端连接对象,获取字节输入流，读取客户端图片
		InputStream in = socket.getInputStream();
		//将目的文件夹封装到File对象
		File upload = new File("e:\\upload");
		if(!upload.exists()) {
			upload.mkdirs();
			
		}
		//防止文件同名被覆盖，从新定义文件的名字
		//规则 :域名+毫秒值+6位随机数
		String filename = "itcast"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
		//创建字节输出流，将图片写入目的文件夹中
		FileOutputStream fos = new FileOutputStream(upload+File.separator+"t.jpg");
		//读写字节数组
		byte[] bytes = new byte[1024];
		int len=0;
		while((len = in.read(bytes))!=-1) {
			fos.write(bytes,0,len);
		}
		//通过客户端连接对象获取字节输出流
		//上传成功写回客户端
		socket.getOutputStream().write("上传成功".getBytes());
		
		fos.close();
		socket.close();
		server.close();
		
	}
}

~~~

##### 32.1.7多线程上传案例

![1560177980668](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1560177980668.png)

~~~java
package cn.itcast.demo4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Upload implements Runnable {
	private Socket socket;
	public Upload(Socket socket) {this.socket=socket;}
	public void run()  {
		try {
		//通过客户端连接对象,获取字节输入流，读取客户端图片
		InputStream in = socket.getInputStream();
		//将目的文件夹封装到File对象
		File upload = new File("e:\\upload");
		if(!upload.exists()) {
			upload.mkdirs();
			
		}
		//防止文件同名被覆盖，从新定义文件的名字
		//规则 :域名+毫秒值+6位随机数
		String filename = "itcast"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
		//创建字节输出流，将图片写入目的文件夹中
		FileOutputStream fos = new FileOutputStream(upload+File.separator+filename);
		//读写字节数组
		byte[] bytes = new byte[1024];
		int len=0;
		while((len = in.read(bytes))!=-1) {
			fos.write(bytes,0,len);
		}
		//通过客户端连接对象获取字节输出流
		//上传成功写回客户端
		socket.getOutputStream().write("上传成功".getBytes());
		
		fos.close();
		socket.close();
		}catch(Exception ex) {
			
		}
	}
	
}

~~~

~~~java
package cn.itcast.demo4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPThreadServer {
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(8888);
		while(true) {
		//获取到一个客户端，必须开启新线程
		Socket socket = server.accept();
		new Thread( new Upload(socket)).start();
		}
	}
}

~~~



