package cn.xinhua.com.modal;

import java.util.List;

public class Page {
	private int currentPageIndex;		//��ʾ��ǰҳ��
	private int pageCount;		//�ܹ��ж���ҳ
	private int count;			//ÿҳ��ʾ����������
	
	private List<Find> listFind;	//�����б�
	private List<Lost> listLost;
	
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Find> getListFind() {
		return listFind;
	}

	public void setListFind(List<Find> listFind) {
		this.listFind = listFind;
	}

	public List<Lost> getListLost() {
		return listLost;
	}

	public void setListLost(List<Lost> listLost) {
		this.listLost = listLost;
	}

	

	

}
