package cn.xinhua.com.dao;

import java.util.List;



import cn.xinhua.com.modal.Find;
import cn.xinhua.com.modal.Lost;

public interface Dao {

	//���ʧ�ﵽ���ݿ����ݲ�
	public boolean addFind(Find find);

	//�������ݿ��е�ʧ�����ݲ�
	public boolean find(Lost findLost);
	
	public int getTotalDataCount(String op);

	public List<Find> listFind(int start,int count);

	public List<Lost> listLost(int start, int count);

}
