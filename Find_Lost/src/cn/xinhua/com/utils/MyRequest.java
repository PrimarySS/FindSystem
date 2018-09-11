package cn.xinhua.com.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//GET的全站中文乱码问题的自定义Request方法
public class MyRequest extends HttpServletRequestWrapper{

	public MyRequest(HttpServletRequest request) {
		super(request);
	}
	
	//自定义Request方法
	public String getParameter(String name){
		String value = super.getParameter(name);
		//判断是否为GET的方式请求
		if(super.getMethod().equalsIgnoreCase("GET")){
			try {
				value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

}
