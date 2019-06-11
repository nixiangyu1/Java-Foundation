package cn.itcast.gjp.service;
/*
 * ҵ�����
 * ������һ�㣬���Ʋ�controller������
 * �������㣬���ݸ�dao�㣬�������ݿ�
 * ����dao���е��࣬���Աλ�ã�����Dao��Ķ���
 */

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	
	/*
	 * ���巽����ʵ��ɾ��������
	 * ��controller����ã���������id
	 * ����dao�㷽������������id
	 */
	public void deleteZhangWu(int zwid) {
		dao.deleteZhangWu(zwid);
	}
	
	/*
	 * ���巽����ʵ�ֱ༭����
	 * �ɿ��Ʋ���ã�����ZhangWu����
	 * ����dao�㷽��������ZhangWu����
	 * 
	 */
	
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
	/*
	 * ���巽����ʵ���������
	 * ���ɿ��Ʋ���ã�����ZhangWu���Ͷ���
	 * ����dao�㷽��������ZhangWu����
	 */
	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	/*
	 * ���巽����ʵ��������ѯ����
	 * �����ɿ��Ʋ���ã��������������ַ���
	 * ����dao��ķ������������������ַ���
	 * ��ȡ����ѯ�����
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return dao.select(startDate, endDate);
	}
	/*
	 * ���巽����ʵ�ֲ�ѯ���е���������
	 * �˷������ɿ��Ʋ���ã�ȥ����dao��ķ���
	 * ���ش洢ZhangWu�����List����
	 */
	public List<ZhangWu> selectAll() {
		
		return dao.selectAll();
	}
	
	
}
