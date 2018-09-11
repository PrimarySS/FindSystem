package cn.xinhua.com.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//GET��ȫվ��������������Զ���Request����
public class MyRequest extends HttpServletRequestWrapper{

	public MyRequest(HttpServletRequest request) {
		super(request);
	}
	
	//�Զ���Request����
	public String getParameter(String name){
		String value = super.getParameter(name);
		//�ж��Ƿ�ΪGET�ķ�ʽ����
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
