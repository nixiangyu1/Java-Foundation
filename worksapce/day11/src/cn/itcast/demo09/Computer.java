package cn.itcast.demo09;
/*
 * ����ʼǱ���
 * ���ܣ����� �ػ���ʹ��USB�豸
 */
public class Computer {
	public void openComputer() {
			System.out.println("�ʼǱ�����");
	}
	public void closeComputer(){
			System.out.println("�ʼǱ��ػ�");
	}
	
	//ʹ��USB�豸���ĸ��豸
	//�����Ĳ���������USB�豸
	public void useUSB(USB usb){
		usb.open();
		usb.close();
		
	}
}