package cn.xinhua.com.dao;

import java.util.List;



import cn.xinhua.com.modal.Find;
import cn.xinhua.com.modal.Lost;

public interface Dao {

	//添加失物到数据库数据层
	public boolean addFind(Find find);

	//查找数据库中的失物数据层
	public boolean find(Lost findLost);
	
	public int getTotalDataCount(String op);

	public List<Find> listFind(int start,int count);

	public List<Lost> listLost(int start, int count);

}
