package cn.xinhua.com.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	
	//�������ӳأ�ͨ��ds������Ӷ���
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	//�ṩ��ȡ���ӵķ���
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("��������æ������");
		}
	}

}
