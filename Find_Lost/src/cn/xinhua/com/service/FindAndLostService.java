package cn.xinhua.com.service;

import cn.xinhua.com.modal.Find;
import cn.xinhua.com.modal.Lost;
import cn.xinhua.com.modal.Page;

public interface FindAndLostService {

	//���ʧ�ﵽ���ݿ�
	public boolean addFind(Find find);

	//�������ݿ��е�ʧ��
	public boolean find(Lost findLost);

	//��ҳ����
	public Page getPage(int currentPageIndex, int count,String op);

}
