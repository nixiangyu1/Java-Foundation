package cn.itcast.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.JDBCUtil.JDBCUtils;
import cn.itcast.domain.Sort;

/*
 * JDBC��ȡ����sort,ÿ�����ݷ�װ��Sort��Ķ�����
 * �ܶ��Sort����󣬴洢��List������
 */
public class JDBCDemo {
	public static void main(String[] args) throws Exception{
		//ʹ��JDBC�����ֱ࣬�ӻ�ȡ���ݿ����Ӷ���
		Connection con=JDBCUtils.getConnection();
		//���ӻ�ȡ���ݿ�SQL���ִ���߶���
		PreparedStatement pst = con.prepareStatement("SELECT * FROM sort");
		ResultSet rs = pst.executeQuery();
		//�������϶���
		List<Sort> list = new ArrayList<Sort>();
		while(rs.next()) {
			//��ȡ��ÿ�������ݣ���װ��Sort������
			Sort s = new Sort(rs.getInt("sid"),rs.getString("sname"),rs.getDouble("sprice"),rs.getString("sdesc"));
			list.add(s);
		}
		//����List����
		for(Sort s:list) {
			System.out.println(s);
		}
		JDBCUtils.close(con, pst, rs);
	}
}
