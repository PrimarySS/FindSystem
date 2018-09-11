package cn.xinhua.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xinhua.com.modal.Page;
import cn.xinhua.com.service.FindAndLostService;
import cn.xinhua.com.service.Impl.FindAndLostServiceImpl;


public class ListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����һ��ҵ���߼���
		FindAndLostService service=new FindAndLostServiceImpl();
		
		//��õ�ǰҳ��
		int currentPageIndex = Integer.parseInt(request.getParameter("currentPageIndex"));
		
		//һҳ��Ҫ��ʾ��������
		int count=2;
		
		//�õ���������
		String op=request.getParameter("op");
		
		//�õ���Ҫ�б����������
		Page page=service.getPage(currentPageIndex,count,op);
		
		//������ҳ��
		request.setAttribute("page", page);
		
		//���ݲ������ݿ������ʾ����
		if("find".equals(op)){
			request.getRequestDispatcher("/listFind.jsp").forward(request, response);
			return;
		}
		else if("lost".equals(op)){
			request.getRequestDispatcher("/listLost.jsp").forward(request, response);
			return;
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
