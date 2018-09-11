package cn.xinhua.com.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 
 * ʹ��c3p0����Դ��dbUtils�е�QueryRunner����������ݿ�Ĳ���
 * @author asus
 *
 */
public class JDBCUtils {
	private static DataSource  ds;
	
	static {
		ds=new ComboPooledDataSource();
		//��������޷���ѯ���⣬���ֶ�д�����ӻ��������ļ�����������д��jdbc:mysql://localhost:3306/xianyu1?characterEncoding=utf8
//		ds.setJdbcUrl("jdbc:mysql://localhost:3306/xianyu1?useSSL=true&characterEncoding=utf8");
	}
	
	public static QueryRunner getQureyRunner(){
		return new QueryRunner(ds);
		
	}
	
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static void release(Connection con,Statement stmt){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void release(Connection con,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		release(con,stmt);
	}
}
