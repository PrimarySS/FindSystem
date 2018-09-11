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

//当前Filter用于解决全站中文乱码问题.
public class EncodingFilter implements Filter{

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		//进行Request与Response对象的类型强转
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		//请求的中文乱码(GET\POST)
		request.setCharacterEncoding("UTF-8");
		//响应的中文乱码
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		//使用自定义的请求
		MyRequest myRequest = new MyRequest(request);
		
		//放行
		arg2.doFilter(myRequest, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

	public void destroy() {
		
	}

}
