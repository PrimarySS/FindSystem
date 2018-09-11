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
		//创建一个业务逻辑类
		FindAndLostService service=new FindAndLostServiceImpl();
		
		//获得当前页面
		int currentPageIndex = Integer.parseInt(request.getParameter("currentPageIndex"));
		
		//一页需要显示多少数据
		int count=2;
		
		//得到操作参数
		String op=request.getParameter("op");
		
		//得到需要列表出来的数据
		Page page=service.getPage(currentPageIndex,count,op);
		
		//请求获得页面
		request.setAttribute("page", page);
		
		//根据操作数据库参数显示数据
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
