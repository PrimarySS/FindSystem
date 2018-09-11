package cn.xinhua.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xinhua.com.utils.MyRequest;

//��ǰFilter���ڽ��ȫվ������������.
public class EncodingFilter implements Filter{

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		//����Request��Response���������ǿת
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		//�������������(GET\POST)
		request.setCharacterEncoding("UTF-8");
		//��Ӧ����������
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		//ʹ���Զ��������
		MyRequest myRequest = new MyRequest(request);
		
		//����
		arg2.doFilter(myRequest, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

	public void destroy() {
		
	}

}
