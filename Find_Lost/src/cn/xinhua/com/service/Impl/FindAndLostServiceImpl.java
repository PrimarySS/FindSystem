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
	
	//���ʧ�ﵽ���ݿ�����
	public boolean addFind(Find find) {
		//��װϵͳʱ��
		find.setDate(new Timestamp(System.currentTimeMillis()));
		
		//�ѷ��񴫵����ݲ�
		boolean flag = dao.addFind(find);
		
		return flag;
	}

	//�������ݿ��е�ʧ������
	public boolean find(Lost findLost) {
		//��װϵͳʱ��
		findLost.setDate(new Timestamp(System.currentTimeMillis()));
		
		//�ѷ��񴫵����ݲ�
		boolean flag = dao.find(findLost);
		
		return flag;
	}
	
	//findʧ������
	public List<Find> listFindData(int currentPageIndex, int count) {
		//������·�����Ϣ����ҳ��
		int start=currentPageIndex * count;
		
		//�ѷ��񴫵����ݲ�
		List<Find> list=dao.listFind(start,count);
		
		return list;
	}
	
	//lostʧ������
	public List<Lost> listLostData(int currentPageIndex, int count){
		//������·�����Ϣ����ҳ��
		int start = currentPageIndex * count;
		
		//�ѷ��񴫵����ݲ�
		List<Lost> list = dao.listLost(start,count);
		
		return list;
	}
	
	/*
	 * ��ҳ����
	 * 
	 * ��ǰҳ��
	 * ������ʾ��
	 * ��������
	 * @see cn.xinhua.com.service.FindAndLostService#getPage(int, int, java.lang.String)
	 */
	public Page getPage(int currentPageIndex, int count,String op) {
		
		int totalDataCount = dao.getTotalDataCount(op);
		
		//�����ҳ��
		int pageCount = (totalDataCount + count - 1) / count;
		
		//���Ʒ�ҳ��Χ����
		if(currentPageIndex > pageCount - 1){
			currentPageIndex = pageCount-1;
		}
		if(currentPageIndex < 0){
			currentPageIndex = 0;
		}
		
		Page page=new Page();
		
		//��װÿҳ��ʾ������
		page.setCount(count);
		
		//��װ��ҳ��
		page.setPageCount(pageCount);
		
		//��װ��ǰҳ
		page.setCurrentPageIndex(currentPageIndex);
		
		//���ݲ���������װ�����ҳ����
		if("find".equals(op)){
			List<Find> list = listFindData(currentPageIndex,count);
			
			//ҳ�����ݷ�װ�������
			page.setListFind(list);
		}
		if("lost".equals(op)){
			List<Lost> list = listLostData(currentPageIndex,count);
			
			//ҳ�����ݷ�װ�������
			page.setListLost(list);
			
		}
		return page;
	}

	
}
