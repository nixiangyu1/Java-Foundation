package cn.itcast.gjp.controller;
/*
 * ��������
 * ������ͼ��������ݣ����ݴ��ݸ�service��
 * ��Աλ�ã�����service����
 */

import java.util.List;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;

public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
	
	/*
	 * ���巽����ʵ��������ӹ���
	 * ����ͼ����ã����ݲ���(���ݹ����Ĳ���������5�����ݣ����ݵ�ʱһ��ZhangWu���͵�)
	 * ��������service��ķ���,����ZhangWu����,��ȡ����Ӻ�Ľ����(��ӳɹ�������,int)
	 */
	public void addZhangWu(ZhangWu zw) {
		service.addZhangWu(zw);
	}
	
	/*
	 * ���巽����ʵ��ɾ��������
	 * ��ͼ����ã�����int��������
	 * ����service�㷽������������int
	 */
	public void deleteZhangWu(int zwid) {
		service.deleteZhangWu(zwid);
	}
	/*
	 * ���巽����ʵ�ֱ༭������
	 * ����ͼ�����,���ݲ���,Ҳ��ZhangWu����
	 * ����service�㷽��������ZhangWu����
	 */
	public void editZhangWu(ZhangWu zw) {
	 	service.editZhangWu(zw);
	}
	/*
	 * ���巽��,��������ѯ����
	 * ��������ͼ�����,�����������ڵ��ַ���
	 * ����service��ķ������������������ַ���,��ȡ�����
	 * ��������ظ���ͼ
	 * 
	 * 
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return	service.select(startDate, endDate);
	}
	/*
	 * ���Ʋ��ඨ�巽����ʵ�ֲ�ѯ���е���������
	 * ��������ͼ����ã���������service��
	 * 
	 * 
	 */
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}
}
