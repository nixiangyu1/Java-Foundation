package cn.itcast.demo09;

public class Test {
	public static void main(String[] args) {
		//�����ʼǱ�����ӵ�бʼǱ�����
		Computer com =new Computer();
		com.openComputer();
		
		//���ñʼǱ�ʹ��USB�豸�ķ���
		//��������USB�ӿ����ͣ��ӿڲ��ܽ�������
		//���÷���������USB�ӿڵ�ʵ�������
		com.useUSB(new Mouse());
		//ʹ��USB�豸��ʹ�ü���
		com.useUSB(new Keyboard());
		
		com.closeComputer();
	}
}
