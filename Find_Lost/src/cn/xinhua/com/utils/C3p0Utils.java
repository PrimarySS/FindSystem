package cn.xinhua.com.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	
	//创建连接池，通过ds获得链接对象
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	//提供获取链接的方法
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器繁忙！！！");
		}
	}

}
