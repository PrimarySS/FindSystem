package cn.xinhua.com.service.Impl;

import java.sql.Timestamp;
import java.util.List;

import cn.xinhua.com.dao.Dao;
import cn.xinhua.com.dao.Impl.DaoImpl;
import cn.xinhua.com.modal.Find;
import cn.xinhua.com.modal.Lost;
import cn.xinhua.com.modal.Page;
import cn.xinhua.com.service.FindAndLostService;

public class FindAndLostServiceImpl implements FindAndLostService {

	private Dao dao = new DaoImpl();
	
	//添加失物到数据库服务层
	public boolean addFind(Find find) {
		//封装系统时间
		find.setDate(new Timestamp(System.currentTimeMillis()));
		
		//把服务传到数据层
		boolean flag = dao.addFind(find);
		
		return flag;
	}

	//查找数据库中的失物服务层
	public boolean find(Lost findLost) {
		//封装系统时间
		findLost.setDate(new Timestamp(System.currentTimeMillis()));
		
		//把服务传到数据层
		boolean flag = dao.find(findLost);
		
		return flag;
	}
	
	//find失物结果集
	public List<Find> listFindData(int currentPageIndex, int count) {
		//获得最新发布信息所在页面
		int start=currentPageIndex * count;
		
		//把服务传到数据层
		List<Find> list=dao.listFind(start,count);
		
		return list;
	}
	
	//lost失物结果集
	public List<Lost> listLostData(int currentPageIndex, int count){
		//获得最新发布信息所在页面
		int start = currentPageIndex * count;
		
		//把服务传到数据层
		List<Lost> list = dao.listLost(start,count);
		
		return list;
	}
	
	/*
	 * 分页处理
	 * 
	 * 当前页面
	 * 数据显示数
	 * 操作参数
	 * @see cn.xinhua.com.service.FindAndLostService#getPage(int, int, java.lang.String)
	 */
	public Page getPage(int currentPageIndex, int count,String op) {
		
		int totalDataCount = dao.getTotalDataCount(op);
		
		//获得总页数
		int pageCount = (totalDataCount + count - 1) / count;
		
		//控制翻页范围操作
		if(currentPageIndex > pageCount - 1){
			currentPageIndex = pageCount-1;
		}
		if(currentPageIndex < 0){
			currentPageIndex = 0;
		}
		
		Page page=new Page();
		
		//封装每页显示的数据
		page.setCount(count);
		
		//封装总页数
		page.setPageCount(pageCount);
		
		//封装当前页
		page.setCurrentPageIndex(currentPageIndex);
		
		//根据操作参数封装处理分页数据
		if("find".equals(op)){
			List<Find> list = listFindData(currentPageIndex,count);
			
			//页面数据封装到结果集
			page.setListFind(list);
		}
		if("lost".equals(op)){
			List<Lost> list = listLostData(currentPageIndex,count);
			
			//页面数据封装到结果集
			page.setListLost(list);
			
		}
		return page;
	}

	
}
