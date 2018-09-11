package cn.xinhua.com.dao.Impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import cn.xinhua.com.dao.Dao;
import cn.xinhua.com.modal.Find;
import cn.xinhua.com.modal.Lost;

import cn.xinhua.com.utils.C3p0Utils;
import cn.xinhua.com.utils.JDBCUtils;

public class DaoImpl implements Dao {

	//������ݿ�����
	QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
	
	//���ʧ�ﵽ���ݿ�����ʵ��
	public boolean addFind(Find find) {
		
		try {
			// sql���
			String sql = "insert into find values(?,?,?,?,?,?,?,?)";
			
			// ���뵽���ݿ�
			int index = runner.update(sql, find.getId(),find.getThing(),find.getTime(),find.getWhere(),
					find.getPhone(),find.getDescription(),find.getPhoto(),find.getDate());

			// ����ɹ�
			if (index > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//���ݿ������ʧ��ʵ��
	public boolean find(Lost lost) {
		
		try {
			// sql���
			String sql = "insert into lost values(?,?,?,?,?,?,?,?)";

			// ���뵽���ݿ�
			int index = runner.update(sql, lost.getId(),lost.getThing(),lost.getTime(),lost.getWhere(),
					lost.getPhone(),lost.getDescription(),lost.getPhoto(),lost.getDate());

			// ����ɹ�
			if (index > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//find��ǰҳ��ʾ����
	public List<Find> listFind(int start,int count) {
		String sql="select * from find order by date desc limit ?,?";
		try {
			return JDBCUtils.getQureyRunner().query(sql,new BeanListHandler<Find>(Find.class),start,count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//lost��ǰҳ��ʾ����
	public List<Lost> listLost(int start,int count) {
		String sql="select * from lost order by date desc limit ?,?";
		try {
			return JDBCUtils.getQureyRunner().query(sql,new BeanListHandler<Lost>(Lost.class),start,count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//��ҳ������
	public int getTotalDataCount(String op) {
		
		//ʹ�þۼ������õ��ж�������¼
		String sql="";
		
		if("lost".equals(op))
			sql="select count(*) from lost";
		if("find".equals(op))
			sql="select count(*) from find";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			//�������
			con=C3p0Utils.getConnection();
			//����Ԥ�������
			pstmt=con.prepareStatement(sql);
			
			//��ý�����������
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
		
	}
	
}
