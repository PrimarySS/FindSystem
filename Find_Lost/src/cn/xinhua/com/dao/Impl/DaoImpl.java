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

	//获得数据库连接
	QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
	
	//添加失物到数据库数据实现
	public boolean addFind(Find find) {
		
		try {
			// sql语句
			String sql = "insert into find values(?,?,?,?,?,?,?,?)";
			
			// 插入到数据库
			int index = runner.update(sql, find.getId(),find.getThing(),find.getTime(),find.getWhere(),
					find.getPhone(),find.getDescription(),find.getPhoto(),find.getDate());

			// 插入成功
			if (index > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//数据库中添加失物实现
	public boolean find(Lost lost) {
		
		try {
			// sql语句
			String sql = "insert into lost values(?,?,?,?,?,?,?,?)";

			// 插入到数据库
			int index = runner.update(sql, lost.getId(),lost.getThing(),lost.getTime(),lost.getWhere(),
					lost.getPhone(),lost.getDescription(),lost.getPhoto(),lost.getDate());

			// 插入成功
			if (index > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//find当前页显示数据
	public List<Find> listFind(int start,int count) {
		String sql="select * from find order by date desc limit ?,?";
		try {
			return JDBCUtils.getQureyRunner().query(sql,new BeanListHandler<Find>(Find.class),start,count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//lost当前页显示数据
	public List<Lost> listLost(int start,int count) {
		String sql="select * from lost order by date desc limit ?,?";
		try {
			return JDBCUtils.getQureyRunner().query(sql,new BeanListHandler<Lost>(Lost.class),start,count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//分页数操作
	public int getTotalDataCount(String op) {
		
		//使用聚集函数得到有多少条记录
		String sql="";
		
		if("lost".equals(op))
			sql="select count(*) from lost";
		if("find".equals(op))
			sql="select count(*) from find";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			//获得连接
			con=C3p0Utils.getConnection();
			//创建预处理对象
			pstmt=con.prepareStatement(sql);
			
			//获得结果集对象对象
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
