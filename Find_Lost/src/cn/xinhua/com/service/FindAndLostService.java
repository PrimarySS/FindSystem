package cn.xinhua.com.service;

import cn.xinhua.com.modal.Find;
import cn.xinhua.com.modal.Lost;
import cn.xinhua.com.modal.Page;

public interface FindAndLostService {

	//添加失物到数据库
	public boolean addFind(Find find);

	//查找数据库中的失物
	public boolean find(Lost findLost);

	//分页处理
	public Page getPage(int currentPageIndex, int count,String op);

}
